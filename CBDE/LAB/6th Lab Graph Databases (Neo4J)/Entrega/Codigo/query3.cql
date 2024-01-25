MATCH (c:Customer)-[:BELONGS_TO]->(o:Order)-[:BELONGS_TO]->(l:LineItem)
WHERE c.mktsegment = $SEGMENT AND c.custkey = o.custkey
  AND l.orderkey = o.orderkey AND o.orderdate < $DATE1
  AND l.shipdate > $DATE2
WITH l.orderkey as l_orderkey, sum(l.extendedprice * (1 - l.discount)) as revenue,
     o.orderdate as o_orderdate, o.shippriority as o_shippriority
RETURN l_orderkey, revenue, o_orderdate, o_shippriority
ORDER BY revenue DESC, o_orderdate;