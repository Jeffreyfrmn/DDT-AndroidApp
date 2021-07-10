# README

This README documents the steps that are necessary to get the application up and running for software development.

Package: ***com.deltadevteam.app.android***

### What is this repository for?
> This repository is for development, debugging, and validation of Delta Development Team's INC. general purpose android application.  This software is used to view data from Delta Development Team, INC. Bluetooth enabled devices, running the 'BlueST Protocol'.

## Requirements Before Development
- A BlueST Protocol Enabled *sending* Device (*ex. APRU, TBS*)
- An Android *receiving* Device (*ex. Phone or Tablet*) configured for development.
- Permissions to clone this repository.

## Developer Installation
1. [Download and Install **Git** Version Controll.](https://git-scm.com/downloads)
2. [Download and Install the **Android Studio IDE**.](https://developer.android.com/studio)
3. **Launch the Android Studio IDE** and navigate to:
```File -> New --> Project from Version Control...```
4. When the *Get from Version Control* window appears, **paste the following address into the URL field**: ```https://github.com/Jeffreyfrmn/DDT-AndroidApp.git``` and (*if applicable*) set the desired directory the repository will be cloned to.
> Note: Ensure you have the available permissions to clone the above repository.

### Configuring Android Devices for App Development
> Android Studio IDE offers use of Android Virtual Machines, however since Bluetooth is a hardware feature, requiring permissions and complexities that may create issues within the development cycle, we have opted to debug this application with hardware connected directly to the IDE.

#### Using Lenovo M8 Tablet for Development
Currently we use the [Lenovo M8 Tablet](https://www.lenovo.com/us/en/tablets/android-tablets/lenovo-tab-series/Lenovo-TB-8505/p/ZZITZTATB58) for production and development purposes at Delta Development Team. Below outlines the process to configure the tablet for Development Mode and USB Debugging permissions.
1. Touch **Advanced Menu on Home screen**.
2. Tap **Settings**.
3. Tap **About tablet**.
4. Seven taps on **Build number** until “You are now a developer” or “No need, you are already a developer” pops out.
5. Tap **Developer options** on the Settings menu.
6. Turn on **USB debugging**.
7. Tap **OK** to allow USB debugging.

#### Purchasing Lenovo M8 Tablet for Development
- [Lenovo M8 Tablet](https://www.lenovo.com/us/en/tablets/android-tablets/lenovo-tab-series/Lenovo-TB-8505/p/ZZITZTATB58)
- [ProCase for M8 Tablet](https://www.amazon.com/ProCase-Shockproof-Kickstand-Protective-TB-8505FS/dp/B08LMCW7KJ/ref=sr_1_6?crid=1SYAN99MEJA7L&dchild=1&keywords=lenovo+m8+tablet+case&qid=1625875922&sprefix=lenovo+m8+t%2Caps%2C207&sr=8-6)
- Micro USB Cable (*used for debugging*)

### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

### Contribution Guidelines
> - Do not change repository gradle files.
> - All directly editable backend (java/kotlin) files are contained in **\src**
> - Repo Contribution Procedures: [See SOP-17 Software Validation](https://drive.google.com/file/d/1miasyqhBxNCYkjjHyrdOgMqzPbwDj2aI/view?usp=sharing)

### Who do I talk to?
> Repo Owner: [Jeffrey Freeman](montio:jfreeman@deltadevteam.com) (Software Lead)

## License
