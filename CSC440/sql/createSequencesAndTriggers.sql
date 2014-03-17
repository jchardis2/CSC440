 create sequence observation_seq;
 create or replace trigger observation_seq Before insert on observation
 for each row 
 begin 	 
	 select observation_seq.NEXTVAL	 
	 into :new.obid	 
	 from dual 
end;
 /
 create sequence observationdoubleinfo_seq;
 create or replace trigger observationdoubleinfo_seq Before insert on observationdoubleinfo
 for each row 
 begin 
	 select observationdoubleinfo_seq.NEXTVAL
	 into :new.obinfoid
	 from dual;
 end;
 /
 create sequence observationintinfo_seq;
 create or replace trigger observationintinfo_seq Before insert on observationintinfo
 for each row 
 begin 
	 select observationintinfo_seq.NEXTVAL
	 into :new.obinfoid
	 from dual;
 end;
 /
  create sequence observationstringinfo_seq;
 create or replace trigger observationstringinfo_seq Before insert on observationstringinfo
 for each row 
 begin 
	 select observationstringinfo_seq.NEXTVAL
	 into :new.obinfoid
	 from dual;
 end;