# Maven Simple Weather

This is a program adapted from Sonatype's "Maven by Example" book. The program specified in the book was modified to take as input any address and return the corresponding current weather report. The modified program uses Google's Geocoding API to get the coordinates corresponding to the address specified, and the Dark Sky API to retrieve the weather forecast for those coordinates.

The purpose of the program is merely to aid in the understanding of Maven, specifically Maven in the context of developing a command line application.

To compile/execute/test, the environment variable `$DARK_SKY_API_KEY` must first be set with an API key attained from https://darksky.net/dev.
