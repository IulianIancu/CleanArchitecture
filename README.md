# README #
## Steps: ##

### 1 Package by layers: ###

* Create a new Java module-> domain layer        
* Create a new Android module-> data layer        
* The default app folder is a presentation layer Cyclic dependencies    

### 2 Cyclic dependencies of build.gradle file ###

* Paste the buildsystem folder in the Project module
* This folder consists of dependencies.gradle file which contains all libraries to be used by other build.gradle file


## However, please follow this: ##

### The idea is simple: clean architecture stands for a group of practices that produce systems that are: ###

* Independent of Frameworks.
* Testable.
* Independent of UI.
* Independent of Database.
* Independent of any external agency.


The purpose is the separation of concerns by keeping the business rules not knowing anything at all about the outside world, thus, they can can be tested without any dependency to any external element.To achieve this, my proposal is about breaking up the project into 3 different layers, in which each one has its own purpose and works separately from the others.

### How would you structure your presentation layer? ###

* Presentation Layer

Is here, where the logic related with views and animations happens. It uses no more than a Model View Presenter (MVP from now on), but you can use any other pattern like MVC or MVVM. I will not get into details on it, but here fragments and activities are only views, there is no logic inside them other than UI logic, and this is where all the rendering stuff takes place.
Presenters in this layer are composed with interactors (use cases) that perform the job in a new thread outside the main android UI thread, and come back using a callback with the data that will be rendered in the view.

### How would you structure your domain layer? ###

* Domain Layer 

Business rules here: all the logic happens in this layer. Regarding the android project, you will see all the interactors (use cases) implementations here as well.This layer is a pure java module without any android dependencies. All the external components use interfaces when connecting to business objects.

### How would you structure your Data layer? ###

* Data Layer

All data needed for the application comes from this layer through a UserRepository implementation (the interface is in the domain layer) that uses a Repository Pattern with a strategy that, through a factory, picks different data sources depending on certain conditions.

For instance, when getting a user by id, the disk cache data source will be selected if the user already exists in cache, otherwise the cloud will be queried to retrieve the data and later save it to the disk cache.

The idea behind all this is that the data origin is transparent for the client, which does not care if the data is coming from memory, disk or the cloud, the only truth is that the data will arrive and will be got.

### What is Dependency inversion principle? ###
Source code dependencies can only point inwards and nothing in an inner circle can know anything at all about something in an outer circle. Domain layer is normally a layer of abstraction between presentation layer and data layer.