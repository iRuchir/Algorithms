#!/bin/sh

## Setting up tomcat base directory.
tomcat_base_dir = "<tomcat_base_directory>"

## Step 1: Check whether tomcat is running already.

if pgrep -x tomcat >/dev/null
then
	echo "Tomcat is running, starting termination."
		./$tomcat_base_directory/bin/shutdown.sh
	else
		echo "Tomcat is not running."
fi

## Step 2: If running, stop tomcat.

if [ $? -eq 0]
then
    echo "Tomcat stopped successfully."
else
    echo "Faced issues while stopping tomcat."
    echo -ne '\007'
    exit 1
fi

## Step 3: Restart tomcat.
echo "Restarting..."
./$tomcat_base_directory/bin/start.sh

## Step 4: Verify if tomcat started successfully.
if [ $? -eq 0]
then
    ## Step 5: Notify user with success message and two bells.
    echo "Tomcat started successfully."
    echo -ne '\007'
    sleep 1
	echo -ne '\007'
else
    ## Step 5: Notify user with failure message and one bell.
    echo "Faced issues while starting tomcat."
	echo -ne '\007'
    exit 2
fi