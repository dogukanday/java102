SELECT city.city, country.country  FROM city
INNER JOIN country ON country.country_id = city.country_id;

SELECT payment.payment_id, customer.first_name, customer.last_name FROM customer
INNER JOIN payment ON payment.customer_id = customer.customer_id;

SELECT rental.rental_id, customer.first_name, customer.last_name FROM customer
INNER JOIN rental ON rental.customer_id = customer.customer_id;

SELECT city.city, country.country
FROM city
LEFT JOIN country ON country.country_id = city.country_id;

SELECT payment.payment_id, customer.first_name, customer.last_name
FROM payment
RIGHT JOIN customer ON customer.customer_id = payment.customer_id;

SELECT rental.rental_id, customer.first_name, customer.last_name
FROM customer
FULL OUTER JOIN rental ON  rental.customer_id = customer.customer_id;

(
	SELECT first_name
	FROM actor
)
UNION
(
	SELECT first_name
	FROM customer
);


(
	SELECT first_name
	FROM actor
)
EXCEPT
(
	SELECT first_name
	FROM customer
);

(SELECT first_name
FROM actor)
UNION ALL
(SELECT first_name
FROM customer);

(SELECT first_name
FROM actor)
INTERSECT ALL --
(SELECT first_name
FROM customer);

(SELECT first_name
FROM actor)
EXCEPT ALL
(SELECT first_name
FROM customer);