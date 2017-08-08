# AJP_Assignment2

This java project is a multithreaded web crawler that uses three search engine, Bing, Yahoo, and Google to generate seeds to crawl the website. User will be prompted to enter their search pharase.

Search engines Bing, and Yahoo is crawled via HTTP request where as Google uses Google [Custom search engine](https://developers.google.com/custom-search/json-api/v1/overview) to get their website seeds.

There will be ten web pages downloaded into the local machine. The files will be overwritten. The webpage download can show the number of occurrence to the search pharase.

This project uses [JavaFX](http://www.oracle.com/technetwork/java/javafx/overview/index.html) as a GUI for the user to interact with. To edit JavaFX quickly, use [JavaFX Scene Builder](http://www.oracle.com/technetwork/java/javafxscenebuilder-1x-archive-2199384.html)

[Assignment Brief and Specs](ST0316-1718S1-Assignment-Part-2.pdf)

Please star the project if you find it useful!

Usage
-----
To run this project, clone it in NetBeans and generate google search engine API key [here](https://developers.google.com/custom-search/json-api/v1/overview) and place it in [here](src/Assignment/SearchInput.java) at ```line 27```
