INSERT INTO categories (name)
VALUES ('Produce'),
       ('Dairy'),
       ('Bakery'),
       ('Meat'),
       ('Beverages'),
       ('Pantry'),
       ('Frozen'),
       ('Snacks');
INSERT INTO products (name, price, description, category_id)
VALUES
-- Produce
('Bananas (1 lb)', 0.79, 'Fresh yellow bananas sold per pound. Great for smoothies and snacks.', 1),
('Gala Apples (3 lb bag)', 4.49, 'Crisp and sweet Gala apples, perfect for eating or baking.', 1),

-- Dairy
('Whole Milk 3.25% (4L)', 5.99, 'Fresh whole milk with 3.25% milk fat. Rich and creamy.', 2),
('Large Brown Eggs (12 count)', 4.29, 'Farm fresh large brown eggs, ideal for breakfast and baking.', 2),

-- Bakery
('Whole Wheat Bread Loaf', 3.49, 'Soft whole wheat bread made with 100% whole grains.', 3),

-- Meat
('Chicken Breast Boneless (1 kg)', 12.99, 'Lean boneless chicken breast, perfect for grilling or meal prep.', 4),

-- Beverages
('Orange Juice No Pulp (1.75L)', 4.99, '100% pure orange juice with no pulp, no added sugar.', 5),

-- Pantry
('Basmati Rice (5 kg)', 14.99, 'Long-grain basmati rice with aromatic flavor and fluffy texture.', 6),

-- Frozen
('Frozen Mixed Vegetables (750 g)', 3.99, 'A blend of frozen carrots, peas, corn, and green beans.', 7),

-- Snacks
('Classic Potato Chips (200 g)', 2.99, 'Crispy salted potato chips made from real potatoes.', 8);
