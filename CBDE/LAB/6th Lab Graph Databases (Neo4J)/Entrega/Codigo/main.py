from neo4j import GraphDatabase
from datetime import datetime
import random
import os

# Vectores de información
address = ["Calle 123, Madrid", "Rue 456, Paris", "Avenida XYZ, Lisbon", "123 Main St, New York", "Hauptstrasse 789, Berlin", "Sveavägen 101, Stockholm"]
nation = ["Spain", "France", "Portugal", "USA", "Germany", "Sweden"]
region = ["Madrid", "Île-de-France", "Lisbon", "New York", "Berlin", "Stockholm"]
supplier_name = ["SupplierA", "SupplierB", "SupplierC", "SupplierD", "SupplierE", "SupplierF"]
comment_supplier = ["Good service", "Prompt delivery", "Quality products", "Responsive support", "Reliable supplier", "Excellent communication"]
manufacturer_product = ["ProductX", "ProductY", "ProductZ", "ProductA", "ProductB", "ProductC"]
type_product = ["Electronic", "Clothing", "Food", "Furniture", "Automotive", "Appliances"]
segment_customer = ["Retail", "Wholesale", "Online", "Industrial", "Commercial", "Residential"]

# Connect to Neo4j
uri = "bolt://localhost:7687"
username = "neo4j"
password = "1234567890"

class Neo4jConnection:
    def __init__(self, uri, user, pwd):
        self._uri = uri
        self._user = user
        self._password = pwd
        self._driver = None

    def close(self):
        if self._driver is not None:
            self._driver.close()

    def connect(self):
        self._driver = GraphDatabase.driver(self._uri, auth=(self._user, self._password))
        return self._driver

def create_graph(tx):
    # Create nodes
    for i in range(6):
        tx.run("CREATE (:Region {regionkey: $regionkey, name: $name})",
               regionkey=i, name=region[i])

        tx.run("CREATE (:Nation {nationkey: $nationkey, name: $name, regionkey: $regionkey})",
               nationkey=i, name=nation[i], regionkey=i)
        
        tx.run("CREATE (:PartSupp {pskey: $pskey, supplycost: $supplycost})",
              pskey=i, supplycost=random.uniform(1.0, 50.0))

        tx.run("CREATE (:Supplier {suppkey: $suppkey, name: $name, address: $address, phone: $phone, comment: $comment, "
               "nationkey: $nationkey})",
               suppkey=i, name=random.choice(supplier_name), address=random.choice(address),
               phone=str(random.randint(100000000, 999999999)), comment=random.choice(comment_supplier),
               nationkey=i)

        tx.run("CREATE (:Part {partkey: $partkey, mfgr: $mfgr, size: $size, type: $type})",
               partkey=i, mfgr=random.choice(manufacturer_product), size=random.randint(1, 10),
               type=random.choice(type_product))

        tx.run("CREATE (:LineItem {quantity: $quantity, orderkey: $orderkey, extendedprice: $extendedprice, discount: $discount, tax: $tax, "
               "orderdate: $orderdate, shipdate: $shipdate})",
               orderkey=i,
               quantity=random.randint(1, 100), extendedprice=random.uniform(1.0, 100.0),
               discount=random.uniform(0.0, 0.5), tax=random.uniform(0.0, 0.2),
               shipdate=datetime(2022, 2, 1) if i == 1 else datetime(2022, 3, 1),
               orderdate=datetime(2022, 1, 1))

        tx.run("CREATE (:Order {orderkey: $orderkey, orderdate: $orderdate, shippriority: $shippriority, "
               "custkey: $custkey})",
               orderkey=i, orderdate=datetime(2022, 1, 1),
               shippriority=random.randint(1, 5), custkey=i)
        
        tx.run("CREATE (:Customer {custkey: $custkey, mktsegment: $mktsegment, nationkey: $nationkey})",
               custkey=i, mktsegment=random.choice(segment_customer), nationkey=i)
        

        # Create relationships
        tx.run("MATCH (n: Nation), (r: Region) WHERE n.nationkey = $nationkey AND r.regionkey = $regionkey "
               "CREATE (r)-[:PART_OF]->(n)",
               nationkey=i, regionkey=i)

        tx.run("MATCH (s: Supplier), (n: Nation) WHERE s.suppkey = $suppkey AND n.nationkey = s.nationkey "
               "CREATE (s)-[:LOCATED_IN]->(n)",
               suppkey=i)

        # Relacionar PartSupp con Supplier y Part
        tx.run("MATCH (ps: PartSupp), (s: Supplier), (p: Part) WHERE ps.pskey = $pskey AND s.suppkey = $suppkey AND p.partkey = $partkey "
                "CREATE (ps)-[:CONTAINS]->(s), (ps)-[:CONTAINS]->(p)",
                pskey=i, suppkey=i, partkey=i)

        # Relacionar Customer con Order y Order con LineItem
        tx.run("MATCH (o: Order), (l: LineItem), (c: Customer) WHERE o.orderkey = $orderkey AND l.orderkey = $orderkey AND c.custkey = $custkey "
                "CREATE (c)-[:PLACED]->(o)-[:CONTAINS]->(l)",
                orderkey=i, custkey=i)
        
        tx.run("MATCH (c: Customer), (n: Nation) WHERE c.custkey = $custkey AND n.nationkey = c.nationkey "
               "CREATE (c)-[:BELONGS_TO]->(n)",
               custkey=i)
        
        tx.run("MATCH (p: Part), (s: Supplier) WHERE p.partkey = $partkey AND s.suppkey = $suppkey "
               "CREATE (p)-[:SUPPLIED_BY]->(s)",
               partkey=i, suppkey=i)

        tx.run("MATCH (l: LineItem), (p: Part) WHERE l.partkey = $partkey AND p.partkey = $partkey "
               "CREATE (l)-[:CONTAINS]->(p)",
               partkey=i)

# Path a los archivos de consulta
query_paths = [
    "query1.cql",
    "query2.cql",
    "query3.cql",
    "query4.cql",
]


def read_query_from_file(query_path):
    with open(query_path, "r") as query_file:
        return query_file.read()


# MAIN
def main():
    # Conectar a Neo4j
    connection = Neo4jConnection(uri, username, password)
    driver = connection.connect()

    with driver.session() as session:
        session.run("MATCH (n) DETACH DELETE n")  # drop all data in the database
        session.execute_write(create_graph)

    while True:
        # Crear la sesión de Neo4j
        with driver.session() as session:
            print("Choose what action to perform:")
            print("1. Execute Query 1")
            print("2. Execute Query 2")
            print("3. Execute Query 3")
            print("4. Execute Query 4")
            print("5. Show Graph Database")
            print("0. Exit")

            user_choice = input("Enter the corresponding number: ")

            if user_choice == "0":
                print("Exiting.")
                break

            elif user_choice == "5":
                print("Graph Database:")
                for item in session.run('MATCH (n)-[r]->(m) RETURN n, r, m'):
                    print(f"Node: {item['n']}, Relation: {item['r']}, Node: {item['m']}")

            elif user_choice in ["1", "2", "3", "4"]:
                query_path = query_paths[int(user_choice) - 1]

                query_to_execute = read_query_from_file(query_path)

                input_values = {}

                if user_choice == "1":
                    input_values["DATE"] = input("Enter the shipdate in the format YYYY-mm-dd: ")

                elif user_choice == "2":
                    input_values["SIZE"] = int(input("Enter the SIZE for Query 2: "))
                    input_values["TYPE"] = input("Enter the TYPE for Query 2: ")
                    input_values["REGION"] = input("Enter the REGION for Query 2: ")

                elif user_choice == "3":
                    input_values["SEGMENT"] = input("Enter the SEGMENT for Query 3: ")
                    input_values["DATE1"] = datetime.strptime(input("Enter the start date in the format YYYY-mm-dd: "),
                                                            "%Y-%m-%d").date()
                    input_values["DATE2"] = datetime.strptime(input("Enter the end date in the format YYYY-mm-dd: "),
                                                            "%Y-%m-%d").date()

                elif user_choice == "4":
                    input_values["REGION"] = input("Enter the REGION for Query 4: ")
                    input_values["DATE1"] = datetime.strptime(input("Enter the date in the format YYYY-mm-dd: "),
                                                            "%Y-%m-%d").date()
                    input_values["DATE2"] = datetime.strptime(input("Enter the date in the format YYYY-mm-dd: "),
                                                            "%Y-%m-%d").date()

                result = session.run(query_to_execute, **input_values)
                print("Query Result:")
                for record in result:
                    print(record)
                print()

            else:
                print("\nInvalid choice. Please enter a valid option.\n")

    # Cerrar la conexión
    connection.close()

if __name__ == "__main__":
    main()
