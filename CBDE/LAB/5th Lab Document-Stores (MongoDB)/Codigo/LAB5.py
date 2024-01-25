from pymongo import MongoClient
from datetime import datetime
import random

# Vectores de información
address = ["Calle 123, Madrid", "Rue 456, Paris", "Avenida XYZ, Lisbon", "123 Main St, New York", "Hauptstrasse 789, Berlin", "Sveavägen 101, Stockholm"]
nation = ["Spain", "France", "Portugal", "USA", "Germany", "Sweden"]
region = ["Madrid", "Île-de-France", "Lisbon", "New York", "Berlin", "Stockholm"]
supplier_name = ["SupplierA", "SupplierB", "SupplierC", "SupplierD", "SupplierE", "SupplierF"]
comment_supplier = ["Good service", "Prompt delivery", "Quality products", "Responsive support", "Reliable supplier", "Excellent communication"]
manufacturer_product = ["ProductX", "ProductY", "ProductZ", "ProductA", "ProductB", "ProductC"]
type_product = ["Electronic", "Clothing", "Food", "Furniture", "Automotive", "Appliances"]
segment_costumer = ["Retail", "Wholesale", "Online", "Industrial", "Commercial", "Residential"]



def create_partsupp_collection(mydb):
    mycol = mydb["partsupp"]
    mycol.create_index("r_name")
    insert_into_partsupp(mycol)

     # Imprimir información sobre los documentos en la colección
    print("\n")
    print("Documentos en la colección 'partsupp':")
    for doc in mycol.find():
        print(doc)
        print("\n")
    print("\n")



def create_order_collection(mydb):
    mycol = mydb["order"]
    mycol.create_index("c_mktsegment")
    mycol.create_index("lineitems.l_shipdate")
    mycol.create_index("nation.n_regionkey")
    mycol.create_index("nation.r_name")
    insert_into_order(mycol)
    
    # Imprimir información sobre los documentos en la colección
    print("\n")
    print("Documentos en la colección 'order':")
    for doc in mycol.find():
        print(doc)
        print("\n")
    print("\n")
    
    
def insert_into_partsupp(partSuppCol):
    partSuppCol.drop()

    for i in range(1, 6):
        doc = {
            "ps_partkey": i,
            "ps_suppkey": i,
            "ps_supplycost": i * 0.5,
            "s_acctbal": i * 0.5,
            "s_name": supplier_name[i - 1],
            "s_address": address[i - 1],
            "s_phone": str(random.randint(600000000, 699999999)),
            "s_comment": comment_supplier[i - 1],
            "n_name": nation[i - 1],
            "r_name": region[i - 1],
            "p_mfgr": manufacturer_product[i - 1],
            "p_size": 35, 
            "p_type": type_product[i - 1]
        }
        partSuppCol.insert_one(doc)


def insert_into_order(orderCol):
    orderCol.drop()

    for i in range(1, 6):
        doc = {
            "o_orderkey": i,
            "o_orderdate": datetime(2022, 1, 1), 
            "o_shippriority": i,
            "c_mktsegment": "Retail" if i == 1 else segment_costumer[i - 1],
            "nation": {
                "n_name": nation[i - 1],
                "n_regionkey": i,
                "r_name": region[i - 1],
                "supplier": [{
                    "s_suppkey": i,
                    }
                ]   
            },
            "lineitems": [
                {
                    "l_orderkey": i,
                    "l_extendedprice": i * 1000,
                    "l_discount": 0.1,
                    "l_shipdate": datetime(2022, 2, 1) if i == 1 else datetime(2022, 3, 1),
                    "l_returnflag": "F",
                    "l_linestatus": "F",
                    "l_quantity": i,
                    "l_tax": 0.05
                }
            ]
        }
        orderCol.insert_one(doc)

        
        
def query_partsupp(mydb, size, type, region):
    pipeline_query2 = [
        {"$match": {
            "r_name": {"$eq": region},
            "p_size": {"$gte": int(size)},
            "p_type": {"$eq": type}
        }},
        
        {"$project": {
            "ps_partkey": "$ps_partkey",
            "ps_suppkey": "$ps_suppkey",
            "ps_supplycost": "$ps_supplycost",
            "s_acctbal": "$s_acctbal",
            "n_name": "$n_name",
            "s_address": "$s_address",
            "s_phone": "$s_phone",
            "s_comment": "$s_comment",
        }},
        
        {"$sort": {"s_acctbal": -1, "n_name": 1, "s_name": 1, "ps_partkey": 1}}
    ]
    result_query2 = list(mydb.partsupp.aggregate(pipeline_query2))
    return result_query2


def query_order_1(mydb, date):
    pipeline_query1 = [
        {"$unwind": "$lineitems"},  # Desenreda el array "lineitems"
        {"$match": {"lineitems.l_shipdate": {"$lte": date}}},
        {"$group": {
            "_id": {
                "l_returnflag": "$lineitems.l_returnflag",
                "l_linestatus": "$lineitems.l_linestatus"
            },
            "sum_qty": {"$sum": "$lineitems.l_quantity"},
            "sum_base_price": {"$sum": "$lineitems.l_extendedprice"},
            "sum_disc_price": {"$sum": {"$multiply": ["$lineitems.l_extendedprice", {"$subtract": [1, "$lineitems.l_discount"]}]}},
            "sum_charge": {"$sum": {"$multiply": ["$lineitems.l_extendedprice", {"$subtract": [1, "$lineitems.l_discount"]}, {"$add": [1, "$lineitems.l_tax"]}]}},
            "avg_qty": {"$avg": "$lineitems.l_quantity"},
            "avg_price": {"$avg": "$lineitems.l_extendedprice"},
            "avg_disc": {"$avg": "$lineitems.l_discount"},
            "count_order": {"$sum": 1}
        }},
        {"$sort": {"_id.l_returnflag": 1, "_id.l_linestatus": 1}}
    ]
    result_query1 = list(mydb.order.aggregate(pipeline_query1))
    return result_query1


def query_order_3(mydb, mktsegment, date1, date2):
    pipeline_query3 = [
        {"$unwind": "$lineitems"},
        {"$match":{
            "o_orderdate": {"$lt": date1},
            "lineitems.l_shipdate": {"$gt": date2},
            "c_mktsegment": {"$eq": mktsegment}}
        },
        {"$group": {
            "_id": {
                "l_orderkey": "$lineitems.l_orderkey",
                "o_orderdate": "$o_orderdate",
                "o_shippriority": "$o_shippriority"
            },
            "revenue": {
                "$sum": {
                    "$multiply": [
                        "$lineitems.l_extendedprice",
                        {"$subtract": [1, "$lineitems.l_discount"]}
                    ]
                }
            }
        }},
        {"$match": {"revenue": {"$gt": 0}}},
        
        {"$project": {
            "result": "$_id",
            "o_orderkey": "$_id.l_orderkey",
            "revenue": "$revenue",
            "o_orderdate": "$_id.o_orderdate",
            "o_shippriority": "$_id.o_shippriority"
        }}
    ]

    result_query3 = list(mydb.order.aggregate(pipeline_query3))
    return result_query3


def query_order_4(mydb, region, date):
    newDate = date.replace(year=date.year + 1)
    pipeline_query4 = [
        {
            "$match": {
                "$expr": {"$eq": ["$nation.r_name", region]},
                "o_orderdate": {"$gte": date},
                "o_orderdate": {"$lt": newDate}
            }
        },
        {
            "$unwind": "$lineitems"
        },
        {
            "$group": {
                "_id": {
                    "nation_n_name": "$nation.n_name",
                },
                "revenue": {
                    "$sum": {
                        "$multiply": [
                            "$lineitems.l_extendedprice",
                            {"$subtract": [1, "$lineitems.l_discount"]}
                        ]
                    }
                }
            }
        },
        {
            "$project": {
                "nation_n_name": "$_id.nation_n_name",
                "revenue": "$revenue",
                "_id": 0
            }
        },
        {
            "$sort": {"revenue": -1}
        }
    ]

    result_query4 = list(mydb.order.aggregate(pipeline_query4))
    return result_query4


def valid_date(date):
    year, month, day = date.split('-')
    try:
        datetime(int(year), int(month), int(day))
    except ValueError:
        return False
    return True

def main():
    client = MongoClient(
        host=['localhost:27017'],
        document_class=dict,
        tz_aware=False,
        connect=True
    )
    mydb = client["Lab5_MarcJavi"]

    create_partsupp_collection(mydb)
    create_order_collection(mydb)

    while True:
        print("Elige qué query ejecutar:")
        print("1. Query 1")
        print("2. Query 2")
        print("3. Query 3")
        print("4. Query 4")
        print("0. Salir")

        user_choice = input("Introduce el número de la query que quieres ejecutar (o 0 para salir): ")

        if user_choice == "0":
            print("Saliendo.")
            break  # Salir del bucle si el usuario elige salir

        elif user_choice == "1":
            date = input("Ponga un l_shipdate de lineitem que quiera consultar en el formato YYYY-MM-DD\n")
            while not valid_date(date):
                print("Formato incorrecto\n")
                date = input("Ponga un l_shipdate de lineitem que quiera consultar en el formato YYYY-MM-DD\n")
            result_query = query_order_1(mydb, datetime.strptime(date, "%Y-%m-%d"))
        elif user_choice == "2":
            size = input("Ponga un p_size de part que quiera consultar\n")
            while not size.isdigit():
                print("Formato incorrecto\n")
                size = input("Ponga un p_size de part que quiera consultar\n")
            type = input("Ponga un p_type de part\n")
            region = input("Ponga un r_name de region que quiera consultar\n")
            result_query = query_partsupp(mydb, size, type, region)
        elif user_choice == "3":
            mktsegment = input("Ponga un c_mktsegment de customer que quiera consultar\n")
            date1 = input("Ponga un o_orderdate de orders que quiera consultar en el formato YYYY-MM-DD\n")
            while not valid_date(date1):
                print("Formato incorrecto\n")
                date1 = input("Ponga un o_orderdate de orders que quiera consultar en el formato YYYY-MM-DD\n")
            date2 = input("Ponga un l_shipdate de lineitem que quiera consultar en el formato YYYY-MM-DD\n")
            while not valid_date(date2):
                print("Formato incorrecto\n")
                date2 = input("Ponga un l_shipdate de lineitem que quiera consultar en el formato YYYY-MM-DD\n")
            result_query = query_order_3(mydb, mktsegment, datetime.strptime(date1, "%Y-%m-%d"), datetime.strptime(date2, "%Y-%m-%d"))
        elif user_choice == "4":
            region = input("Ponga un r_name de region que quiera consultar\n")
            date = input("Ponga un o_orderdate de orders que quiera consultar en el formato YYYY-MM-DD\n")
            while not valid_date(date):
                print("Formato incorrecto\n")
                date = input("Ponga un o_orderdate de orders que quiera consultar en el formato YYYY-MM-DD\n")
            result_query = query_order_4(mydb, region, datetime.strptime(date, "%Y-%m-%d"))
        else:
            print("\n")
            print("Elección inválida. Por favor, introduce una opción válida.\n")
            continue  # Volver al inicio del bucle si la opción no es válida

        print(f"Query {user_choice} Resultado:""\n")
        print(result_query)
        print("\n")

if __name__ == "__main__":
    main()
