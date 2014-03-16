

#Gives you all the tables you created
select table_name from user_tables; 
#Gives you all the tables you created in a format you can copy and paste to drop the tables
select 'drop table '||table_name||' cascade constraints;' from user_tables;
