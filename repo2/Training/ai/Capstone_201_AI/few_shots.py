few_shots = [
    {'Question': "How many t-shirts do we have left for Nike in XS size and white color?",
     'SQLQuery': "SELECT sum(stock_quantity) FROM t_shirts WHERE brand = 'Nike' AND color = 'White' AND size = 'XS'",
     'SQLResult': "Result of the SQL query",
     'Answer': "91"},
    
    {'Question': "How much is the total price of the inventory for all S-size t-shirts?",
     'SQLQuery': "SELECT SUM(price*stock_quantity) FROM t_shirts WHERE size = 'S'",
     'SQLResult': "Result of the SQL query",
     'Answer': "22292"},
    
    {'Question': "How much sales amount will be generated if we sell all small size Adidas shirts today after discounts?",
     'SQLQuery': """SELECT sum(a.total_amount * ((100-COALESCE(discounts.pct_discount,0))/100)) as total_revenue from
                    (select sum(price*stock_quantity) as total_amount, t_shirt_id from t_shirts where brand = 'Adidas' and size = 'S'
                    group by t_shirt_id) a left join discounts on a.t_shirt_id = discounts.t_shirt_id""",
     'SQLResult': "Result of the SQL query",
     'Answer': "12345"}
]
