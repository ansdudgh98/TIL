select
    distinct order0_.order_id as order_id1_6_0_,
             member1_.member_id as member_i1_4_1_,
             delivery2_.delivery_id as delivery1_2_2_,
             orderitems3_.order_item_id as order_it1_5_3_,
             item4_.item_id as item_id2_3_4_,
             order0_.delivery_id as delivery4_6_0_,
             order0_.member_id as member_i5_6_0_,
             order0_.order_date as order_da2_6_0_,
             order0_.status as status3_6_0_,
             member1_.city as city2_4_1_,
             member1_.street as street3_4_1_,
             member1_.zipcode as zipcode4_4_1_,
             member1_.name as name5_4_1_,
             delivery2_.city as city2_2_2_,
             delivery2_.street as street3_2_2_,
             delivery2_.zipcode as zipcode4_2_2_,
             delivery2_.delivery_status as delivery5_2_2_,
             orderitems3_.count as count2_5_3_,
             orderitems3_.item_id as item_id4_5_3_,
             orderitems3_.order_id as order_id5_5_3_,
             orderitems3_.order_price as order_pr3_5_3_,
             orderitems3_.order_id as order_id5_5_0__,
             orderitems3_.order_item_id as order_it1_5_0__,
             item4_.name as name3_3_4_,
             item4_.price as price4_3_4_,
             item4_.stock_quantity as stock_qu5_3_4_,
             item4_.artist as artist6_3_4_,
             item4_.etc as etc7_3_4_,
             item4_.author as author8_3_4_,
             item4_.isbn as isbn9_3_4_,
             item4_.actor as actor10_3_4_,
             item4_.director as directo11_3_4_,
             item4_.dtype as dtype1_3_4_
from
    orders order0_
        inner join
    member member1_
    on order0_.member_id=member1_.member_id
        inner join
    delivery delivery2_
    on order0_.delivery_id=delivery2_.delivery_id
        inner join
    order_item orderitems3_
    on order0_.order_id=orderitems3_.order_id
        inner join
    item item4_
    on orderitems3_.item_id=item4_.item_id
