/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Maytopacka
 * Created: Oct 19, 2016
 */

alter table access_logs add access_type int;
update access_logs set access_type = 1 where id_no='0000000001';
update access_logs set access_type = 3 where id_no='0000000003';

update access_logs set access_type = 2 where id_no='0000000002';
update access_logs set access_type = 2 where college<>'';

update access_logs set access_type = 1 where course<>'';

update access_logs set year_level = 'III', course='BS IT' where id_no='14-1-01605';
update access_logs set year_level = 'IV', course='BSN' where id_no='13-1-00169';
update access_logs set year_level = 'IV', course='BS IS' where id_no='13-2-00093';
update access_logs set year_level = 'I', course='SH TV' where id_no='16-1-00873';