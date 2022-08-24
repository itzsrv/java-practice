


Functional Interface

Interfaces with single abstract method qualifies to be called as Funtional Interface.
Catch: It can have multiple default and static methods


Default and Static Methods

Why static methods are introduced in java 8?
static methods restrict the implementation classes to override the provided behaviour of the method and gives the default implementation only.

Are static methods availabe to implementing classes by default?
No, static methods are available with Interface name

Why diamond problem will not occur in static methods?
Because static methods are not part of implementation classes.

How default methods in interface cope up with diamond problem?
Default methods are called with Interface names only, so there is no ambiguity for diamond problem to occur.
InterfaceName.super.methodName();