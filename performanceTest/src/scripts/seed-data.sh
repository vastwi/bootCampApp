#!/bin/bash

set -e
set -E
set -x

hostname=${DBHOSTNAME:-y-qa-vm1.dnspam}
dbname=${DBNAME:-store_replenishment_qa}
username=${USERNAME:-readonly}
port=${PORT:-5445}


PGPASSWORD=Helpdesk psql -h ${hostname} -p ${port} -d ${dbname} -U ${username} -c "copy (select generate_series as draft_order_number from generate_series( (select orders_id_seq.last_value + 1 from draft.orders_id_seq),(select orders_id_seq.last_value + 10 from draft.orders_id_seq))) to STDOUT WITH CSV HEADER" > src/test/resources/data/draft_order_number.csv
PGPASSWORD=Helpdesk psql -h y-qa-vm1.dnspam -p 5436 -d store_assortment_qa -Ureadonly -c "copy (select article_id,2 as quantity from active.assortments a join active.replenishments r using (article_id, store_id) join reference.merchandise_hierarchy mh using (article_id) where store_id = 532 and a.status and r.type = 'C' and merchandise_area_id = 10 limit 2000) to STDOUT WITH CSV HEADER" > src/test/resources/data/articles_to_add.csv