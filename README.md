#WILDLIFE TRACKER

#### It is an app that allows a ranger to register, record and classify animals on whether endangered specie or non endangered specie, add new locations and record sightings of animals based on the mentioned criteria.

#### By **Bartholomew Kelly Egesa**

## Description

A  user can register as a ranger, add a new animal and indicate whether its endangered or not, add a new location and record the sightings if different animals depending on the position of which they were spotted.
A user can also delete a ranger, animal, location and a sighting

## Behavior Driven Development

| BEHAVIOR:Our program should handle |                  Input Example When it receives                   |           Output Example It should return           |
| ---------------------------------- | :---------------------------------------------------------------: | :-------------------------------------------------: |
| Add a new Ranger                           |        Inputs:-name="Kelly Egesa" contactInfo="kelly.egesa@gmail.com" badgeNumber="78951"           |               A new ranger has been added successfully               |
| Add a new Endangered specie                              |   Input:- name="Rhino" age="Young" health="adult" |         A new endangered specie as been added successfully           |
| Add a new Non-Endangered specie                             |                Input:- name="Rhino" age="Young"            |                A new non-endangered specie as been added successfully                  |
| Add a new location                           |           Input:- name="Near river bank"              |               A new location has been added successfully              |
|Add a new sighting                         |               Inputs:-ranger name="Kelly Egesa" location name="Near river bank" animal name="Rhino"          |                 A new sighting has been added successfully                |
| Delete a ranger                            |               Click delete ranger             |                Ranger is deleted           |
| Delete a Endangered specie                            |               Click delete Endangered specie             |                Endangered specie is deleted           |
| Delete a Non-Endangered specie                            |               Click delete Non-Endangered specie             |                Non-Endangered specie is deleted           |
| Delete a location                             |               Click delete location              |                location  is deleted           |
| Delete a sighting                            |               Click delete sighting             |                sighting is deleted           |



## Known Bugs

There are no known bugs

## Setup/Installation Requirements

- Setup git
- Open the terminal application by either clicking on the terminal icon or by clicking Ctrl + alt + T.
- Create a new folder called wildlife-tracker by pressing mkdir wildlife-tracker and pressing enter.
- Navigate to wildlife-tracker by pressing cd wildlife-tracker and pressing enter.
- Go to KellyEgesa github user name on the browser, click on repositories, Click on wildlife-tracker then click on clone or download option
- Copy paste the given Url
- Press git clone plus the url on the terminal then press center
- On the terminal and press gradle run

## Setup Database
- Install postgresql first.
- Navigate to wildlife-tracker by pressing cd wildlife-tracker and pressing enter.
- Enter on the terminal src/main/resources/db/ and press enter.
- Enter psql < create.sql to setup database.
- To delete database enter psql < drop.sql.

## Technologies Used

- JAVA
- SPARK
- HANDLEBARS
- CSS
- BOOTSTRAP
- POSTGRESQL

## Support and contact details

You can contact me via Email at kelly.egesa@gmail.com

### License

_M.I.T_
Copyright (c)2020 **KELLY EGESA**
