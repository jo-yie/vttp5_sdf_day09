# Build and run 

In project root folder, ie. project01am 

To compile 
1. javac -d bio --source-path . ./*.java Card/*.java

To run the compiled bytecode (.class) main entrypoint 

2. java -cp bin project01am.App

To package into jar file, go into the bin folder 
3. jar -c -v -f day0