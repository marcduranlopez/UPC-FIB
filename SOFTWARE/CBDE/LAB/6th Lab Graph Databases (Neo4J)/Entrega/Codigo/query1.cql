MATCH (li:LineItem)
WHERE li.shipdate <= $DATE
WITH li.returnflag as l_returnflag, li.linestatus as l_linestatus,
     sum(li.quantity) as sum_qty, sum(li.extendedprice) as sum_base_price,
     sum(li.extendedprice * (1 - li.discount)) as sum_disc_price,
     sum(li.extendedprice * (1 - li.discount) * (1 + li.tax)) as sum_charge,
     avg(li.quantity) as avg_qty, avg(li.extendedprice) as avg_price,
     avg(li.discount) as avg_disc, count(*) as count_order
RETURN l_returnflag, l_linestatus, sum_qty, sum_base_price,
       sum_disc_price, sum_charge, avg_qty, avg_price, avg_disc, count_order
ORDER BY l_returnflag, l_linestatus;