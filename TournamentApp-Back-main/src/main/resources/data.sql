INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO format(id, broj_ucesnika, tip_takmicenja) VALUES(1, 7, "GRAND_SLAM");
INSERT INTO format(id, broj_ucesnika, tip_takmicenja) VALUES(2, 4, "MASTERS_1000");   
INSERT INTO format(id, broj_ucesnika, tip_takmicenja) VALUES(3, 3, "MASTERS_500");   
INSERT INTO format(id, broj_ucesnika, tip_takmicenja) VALUES(4, 5, "MASTERS_250"); 

INSERT INTO takmicenje(id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id) VALUES(1, "2020-01-01", "2020-05-01", "Beograd", "Beograd Open", 2);
INSERT INTO takmicenje(id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id) VALUES(2, "2020-02-01", "2020-07-01", "Pariz", "Pariz Open", 1);
INSERT INTO takmicenje(id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id) VALUES(3, "2020-03-01", "2020-08-01", "Melburn", "Melburn Open", 3);
INSERT INTO takmicenje(id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id) VALUES(4, "2020-04-01", "2020-09-01", "Skoplje", "Skoplje Open", 4);
INSERT INTO takmicenje(id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id) VALUES(5, "2020-05-01", "2020-10-01", "Novi Sad", "Novi Sad Open", 2);
INSERT INTO takmicenje(id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id) VALUES(6, "2020-06-01", "2020-11-01", "Budimpesta", "Budimpesta Open", 1);

INSERT INTO prijava(id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id) VALUES(1, "2019-01-01", "Srbija", "a@gmail.com", 1);
INSERT INTO prijava(id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id) VALUES(2, "2019-02-01", "Majdarska", "b@gmail.com", 2);
INSERT INTO prijava(id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id) VALUES(3, "2019-03-01", "Nemacka", "c@gmail.com", 3);
INSERT INTO prijava(id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id) VALUES(4, "2019-04-01", "Austrija", "d@gmail.com", 4);
INSERT INTO prijava(id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id) VALUES(5, "2019-05-01", "Pariz", "e@gmail.com", 1);