package com.Interface.SmartHomeController.model;

public interface Controllable 
{
	void turnOn();
	void turnOff();
	void showModes();   
	void setMode(int modeChoice);
}
