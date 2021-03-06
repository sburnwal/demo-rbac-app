INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (1, 'admin', 'Super', 'Admin', 0, 'O', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');
INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (2, 'mkyong', 'Kong', 'My', 25, 'M', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');
INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (3, 'alex', 'Alex', 'Kahn', 35, 'M', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');
INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (4, 'joel', 'Joel', 'John', 45, 'M', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');
INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (5, 'sburnwal', 'Satish', 'Burnwal', 35, 'M', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');
INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (6, 'jrini', 'Rini', 'Johar', 35, 'F', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');
INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (7, 'kbazaz', 'Karan', 'Bazaz', 25, 'M', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');
INSERT INTO USER_ACCOUNT (id, username, first_name, last_name, age, gender, password, update_timestamp) VALUES (8, 'geetap', 'Geeta', 'Prasad', 15, 'F', '$2a$10$j1Sa3n1OFtYOQeGCxegdEeBKd3rZBjRyolQiNlTRLVxRPaIuph9zK', '2018-08-06 11:30:00');

INSERT INTO Role (id, name, description, immutable, update_timestamp) VALUES (1, 'Administrator', 'Can do all operations', true, '2018-08-06 11:30:00');
INSERT INTO Role (id, name, description, immutable, update_timestamp) VALUES (2, 'NetworkDeviceManager', 'Manages network devices', true, '2018-08-06 11:30:00');
INSERT INTO Role (id, name, description, immutable, update_timestamp) VALUES (3, 'EndpointManager', 'Manages endpoints', true, '2018-08-06 11:30:00');
INSERT INTO Role (id, name, description, immutable, update_timestamp) VALUES (4, 'UserAccessManager', 'Manages users and their access', true, '2018-08-06 11:30:00');

INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (1, 'Cisco', 'Nexus7k', '3.02', 'Switch', '2018-08-06 11:30:00');
INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (2, 'Arista', '7250X', '2017.2.3', 'Switch', '2018-08-06 11:30:00');
INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (3, 'Juniper', 'MX10', '18.2R1', 'Router', '2018-08-06 11:30:00');
INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (4, 'Juniper', 'vSRX', '16.2R2', 'Firewall', '2018-08-06 11:30:00');
INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (5, 'Cisco', '4490S', '9.02', 'Switch', '2018-08-06 11:30:00');
INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (6, 'Cisco', '5500P', '8.52', 'Switch', '2018-08-06 11:30:00');
INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (7, 'Huawei', '12800E', 'V200R002', 'Router', '2018-08-06 11:30:00');
INSERT INTO NETWORK_DEVICE (id, make, model, version, type, update_timestamp) VALUES (8, 'Arista', '7500R', '2018.1.0', 'Switch', '2018-08-06 11:30:00');

INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (1, 'Apple', 'Macbook Pro', 'MacOS', '16.2', '2018-08-06 11:30:00');
INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (2, 'Apple', 'Macbook Pro', 'MacOS', '15.4', '2018-08-06 11:30:00');
INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (3, 'Apple', 'iPhone 8s', 'iOS', '16.2', '2018-08-06 11:30:00');
INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (4, 'Google', 'Pixel 2', 'Android Oreo', '9.2', '2018-08-06 11:30:00');
INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (5, 'Samsung', 'Galaxy S8', 'Android Kitkat', '8.1', '2018-08-06 11:30:00');
INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (6, 'Oneplus', '6T', 'Android Kitkat', '8.2', '2018-08-06 11:30:00');
INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (7, 'LG', 'G7 ThinQ', 'Android Oreo', '9.2', '2018-08-06 11:30:00');
INSERT INTO Endpoint (id, make, product_name, os, version, update_timestamp) VALUES (8, 'Huwawei', 'Nova 3i', 'Android Kitkat', '8.2', '2018-08-06 11:30:00');

-- Role bits are like 00000001=1, 00000010=2, 00000100=4, 00001000=8 indicating which bit in on in a long integer. Max 64 priviledges are possible 
INSERT INTO Priviledge (id, priv_name, description, role_bit, immutable, update_timestamp) VALUES (1, 'administration', 'Can do all operations', 1, true, '2018-08-06 11:30:00');
INSERT INTO Priviledge (id, priv_name, description, role_bit, immutable, update_timestamp) VALUES (2, 'manage-network-devices', 'Manages network devices', 2, true, '2018-08-06 11:30:00');
INSERT INTO Priviledge (id, priv_name, description, role_bit, immutable, update_timestamp) VALUES (3, 'manage-endpoints', 'Manages endpoints', 4, true, '2018-08-06 11:30:00');
INSERT INTO Priviledge (id, priv_name, description, role_bit, immutable, update_timestamp) VALUES (4, 'manage-user-access', 'Manages users and access', 8, true, '2018-08-06 11:30:00');

-- Role-Priviledge mappings
INSERT INTO Role_Priviledge(id, role_id, priviledge_id, immutable, update_timestamp) VALUES (1, 1, 1, true, '2018-08-06 11:30:00'); 
INSERT INTO Role_Priviledge(id, role_id, priviledge_id, immutable, update_timestamp) VALUES (2, 2, 2, true, '2018-08-06 11:30:00'); 
INSERT INTO Role_Priviledge(id, role_id, priviledge_id, immutable, update_timestamp) VALUES (3, 3, 3, true, '2018-08-06 11:30:00'); 
INSERT INTO Role_Priviledge(id, role_id, priviledge_id, immutable, update_timestamp) VALUES (4, 4, 4, true, '2018-08-06 11:30:00');

-- entity meta information
INSERT INTO Entity_Meta_Info(id, entity_name, priv_name, immutable, update_timestamp) VALUES (1, 'Endpoint', 'manage-endpoints', true, '2018-08-06 11:30:00'); 
INSERT INTO Entity_Meta_Info(id, entity_name, priv_name, immutable, update_timestamp) VALUES (2, 'NetworkDevice', 'manage-network-devices', true, '2018-08-06 11:30:00'); 
INSERT INTO Entity_Meta_Info(id, entity_name, priv_name, immutable, update_timestamp) VALUES (3, 'Role', 'manage-user-access', true, '2018-08-06 11:30:00'); 
INSERT INTO Entity_Meta_Info(id, entity_name, priv_name, immutable, update_timestamp) VALUES (4, 'Priviledge', 'manage-user-access', true, '2018-08-06 11:30:00');

--roles for users
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (1, 1, 1, true, '2018-08-06 11:30:00'); 
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (2, 2, 2, true, '2018-08-06 11:30:00'); 
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (3, 3, 3, true, '2018-08-06 11:30:00'); 
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (4, 4, 4, true, '2018-08-06 11:30:00'); 
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (5, 5, 1, true, '2018-08-06 11:30:00'); 
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (6, 6, 2, true, '2018-08-06 11:30:00'); 
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (7, 7, 3, true, '2018-08-06 11:30:00'); 
INSERT INTO USERACCOUNT_ROLES(id, user_account_id, role_id, immutable, update_timestamp) VALUES (8, 8, 4, true, '2018-08-06 11:30:00'); 