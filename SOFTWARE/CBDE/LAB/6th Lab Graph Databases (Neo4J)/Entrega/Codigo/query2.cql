MATCH (ps1:PartSupp)-[:BELONGS_TO]->(s1:Supplier)-[:BELONGS_TO]->(n1:Nation)-[:BELONGS_TO]->(r1:Region)
WHERE ps1.size = $SIZE AND ps1.type CONTAINS $TYPE AND s1.nationkey = n1.nationkey
  AND n1.regionkey = r1.regionkey AND r1.name = $REGION
MATCH (ps2:PartSupp)-[:BELONGS_TO]->(s2:Supplier)-[:BELONGS_TO]->(n2:Nation)-[:BELONGS_TO]->(r2:Region)
WHERE ps1.partkey = ps2.partkey AND s2.suppkey = ps2.suppkey
  AND s2.nationkey = n2.nationkey AND n2.regionkey = r2.regionkey
  AND r2.name = $REGION
WITH s1, n1, r1, ps1, s2, n2, r2, MIN(ps2.supplycost) AS min_supplycost
WHERE ps1.supplycost = min_supplycost
RETURN s1.acctbal, s1.name, n1.name, ps1.partkey, ps1.mfgr, s1.address, s1.phone, s1.comment
ORDER BY s1.acctbal DESC, n1.name, s1.name, ps1.partkey;