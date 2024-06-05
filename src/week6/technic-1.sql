SELECT *
FROM film
WHERE title LIKE '%n'
ORDER BY length DESC
LIMIT 5;

SELECT *
FROM film
WHERE title LIKE '%n'
ORDER BY length ASC
OFFSET 5
LIMIT 5;

SELECT *
FROM customer
WHERE store_id = 1
ORDER BY last_name DESC
LIMIT 4;

SELECT ROUND(AVG(rental_rate), 3)
FROM film

SELECT COUNT(*)
FROM film
WHERE title ILIKE 'C%'

SELECT MAX(length)
FROM film
WHERE rental_rate = 0.99;

SELECT COUNT(DISTINCT(replacement_cost))
FROM film
WHERE length > 150;

SELECT rating, COUNT(*)
FROM film
GROUP BY rating;

SELECT replacement_cost, COUNT(*)
FROM film
GROUP BY replacement_cost
HAVING COUNT(*) > 50;

SELECT store_id, COUNT (customer_id)
FROM customer
GROUP BY store_id;

SELECT country_id, COUNT(*)
FROM city
GROUP BY country_id
ORDER BY COUNT(*) DESC
LIMIT 1;