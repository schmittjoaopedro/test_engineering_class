Environment:
Version: releases/tag/v7.5
Language: Java
Solver: Routing Solver
OS: Windows 10 Home Edition

I'm trying to execute the sample code from google or-tools TSP docs for Java (https://developers.google.com/optimization/routing/tsp#java)

I made the following steps:

Extracted the zip file (https://github.com/google/or-tools/releases/download/v7.5/or-tools_VisualStudio2019-64bit_v7.5.7466.zip) in my file system (C:\programas\or-tools-vs2019).
Installed the Visual Studio 2019 Community for C++ local development.
Created a maven project on IntelliJ (Java)
Add the dependent or-tools jar libraries in the project (com.google.ortools.jar and protobuf.jar)
Copied the full TSP Java source code in my project
Linked the library path -Djava.library.path=C:\programas\or-tools-vs2019\lib
However, when I try to run the program, it throws the following error:

Exception in thread "main" java.lang.IllegalAccessError: class com.google.ortools.constraintsolver.RoutingSearchParameters tried to access private field com.google.protobuf.AbstractMessage.memoizedSize (com.google.ortools.constraintsolver.RoutingSearchParameters and com.google.protobuf.AbstractMessage are in unnamed module of loader 'app')
	at com.google.ortools.constraintsolver.RoutingSearchParameters.getSerializedSize(RoutingSearchParameters.java:7367)
	at com.google.protobuf.AbstractMessageLite.toByteArray(AbstractMessageLite.java:64)
	at com.google.ortools.constraintsolver.RoutingModel.solveWithParameters(RoutingModel.java:327)
	at com.github.schmittjoaopedro.vrp.ortools.TspCities.main(TspCities.java:92)
I expect to run the program as presented in docs.
