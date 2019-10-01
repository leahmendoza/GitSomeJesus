--Project 0 GitSomeJesus tables
--Deleting tables in database by using "DROP"
drop table account;
drop table account_priv_jt;
drop table priv;

CREATE TABLE account(
  	user_id serial PRIMARY KEY,
  	name_ varchar (50),
   	username varchar (50),
   	password varchar (50),
   	email varchar (355),
   	address varchar (50)
);

CREATE TABLE priv(
   	priv_id serial PRIMARY KEY,
   	priv_type varchar (50)
);

CREATE TABLE account_priv_jt(
	jt_id serial primary key,
   	user_id_fk int REFERENCES account(user_id) not NULL,
   	priv_id_fk int REFERENCES priv(priv_id) not NULL
);

--Inserting data into account table
insert into account values(default, 'Leah', 'username1', 'password', 'leah@mail.com', '123 Revature Ave. 55555');
insert into account values(default, 'Moe', 'moe182', '1234qwer', 'moe@mail.com', '123 Arlington Street 84034');
insert into account values(default, 'Zoe', 'zoey8', 'pass321', 'zoe@mail.com', '123 UTA Road 23432');
insert into account values(default, 'Poe', 'edgarallen', '54321', 'poe@mail.com', '123 Science Hall 78080');

--Inserting data into priv (privilages) table
insert into priv values(default, 'Read-Only');
insert into priv values(default, 'Write-Only');
insert into priv values(default, 'Update-Only');
insert into priv values(default, 'Delete-Only');

--Inserting data into account_priv_jt table to establish a many-to-many relationship
--Key: 1 = Admin role, 2 = User role
insert into account_priv_jt values(default, 1, 1);
insert into account_priv_jt values(default, 1, 2);
insert into account_priv_jt values(default, 1, 3);
insert into account_priv_jt values(default, 1, 4);

--Viewing data in the databases
select * from account;
select * from priv;
select * from account_priv_jt;

commit;