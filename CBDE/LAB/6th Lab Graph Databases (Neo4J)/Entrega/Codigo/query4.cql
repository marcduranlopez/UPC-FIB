MATCH (c:Customer)-[:BELONGS_TO]->(o:Order)-[:BELONGS_TO]->(l:LineItem)-[:BELONGS_TO]->(s:Supplier)-[:BELONGS_TO]->(n:Nation)-[:BELONGS_TO]->(r:Region)
WHERE c.custkey = o.custkey AND l.orderkey = o.orderkey
  AND l.suppkey = s.suppkey AND c.nationkey = s.nationkey
  AND s.nationkey = n.nationkey AND n.regionkey = r.regionkey
  AND r.name = $REGION AND o.orderdate >= date($DATE1)
  AND o.orderdate < date($DATE2)
WITH n.name as n_name, sum(l.extendedprice * (1 - l.discount)) as revenue
RETURN n_name, revenue
ORDER BY revenue DESC;