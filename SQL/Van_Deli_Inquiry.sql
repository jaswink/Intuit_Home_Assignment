SELECT TOP 1 WITH TIES m.product_name AS Product_Name, COUNT(*) AS Purchase_Count
FROM sales s
INNER JOIN menu m
ON s.product_id=m.product_id
GROUP BY m.product_name
ORDER BY COUNT(*) DESC


SELECT s.customer_id, s.order_date, m.product_name, m.price, Dense_Rank() OVER(PARTITION BY s.customer_id ORDER BY [order_date]) AS [ranking],
CASE WHEN s.order_date>=mem.join_date THEN 'Y'
ELSE 'N'
END AS member
FROM sales s
LEFT JOIN menu m
ON s.product_id=m.product_id
LEFT JOIN members mem
ON s.customer_id=mem.customer_id
ORDER BY s.customer_id, s.order_date
