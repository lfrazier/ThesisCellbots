/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\lfrazier\\workspace\\cellbots\\src\\com\\cellbots\\local\\IRobotControllerService.aidl
 */
package com.cellbots.local;
// Declare the interface.

public interface IRobotControllerService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.cellbots.local.IRobotControllerService
{
private static final java.lang.String DESCRIPTOR = "com.cellbots.local.IRobotControllerService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.cellbots.local.IRobotControllerService interface,
 * generating a proxy if needed.
 */
public static com.cellbots.local.IRobotControllerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.cellbots.local.IRobotControllerService))) {
return ((com.cellbots.local.IRobotControllerService)iin);
}
return new com.cellbots.local.IRobotControllerService.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.connect(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_disconnect:
{
data.enforceInterface(DESCRIPTOR);
this.disconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_sendCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.sendCommand(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getSensorData:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.getSensorData(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_getPose:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getPose();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getOdometer:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
java.lang.String _result = this.getOdometer(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_resetOdometer:
{
data.enforceInterface(DESCRIPTOR);
this.resetOdometer();
reply.writeNoException();
return true;
}
case TRANSACTION_getStateJson:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getStateJson();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.cellbots.local.IRobotControllerService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// Connects to the robot over the specified Bluetooth device

public void connect(java.lang.String username, java.lang.String robotBtName, java.lang.String robotBtAddr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(username);
_data.writeString(robotBtName);
_data.writeString(robotBtAddr);
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Disconnect from the robot

public void disconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Sends the specified command string to the robot over Bluetooth

public void sendCommand(java.lang.String cmd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(cmd);
mRemote.transact(Stub.TRANSACTION_sendCommand, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Returns the specified sensor data

public byte[] getSensorData(int sensorType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sensorType);
mRemote.transact(Stub.TRANSACTION_getSensorData, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Returns pose as a String formatted as "x:y:th"

public java.lang.String getPose() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPose, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Returns cumulative distance and heading as a String formatted as "distance:heading"

public java.lang.String getOdometer(boolean reset) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((reset)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_getOdometer, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Resets the cumulative distance and heading

public void resetOdometer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_resetOdometer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Returns the sensor state of the robot as a JSON string

public java.lang.String getStateJson() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getStateJson, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Checks the state of the controller
// returns 0 - failed connecting to Bluetooth
//         1 - success, and ready to accept messages
//         2 - NONE, i.e. currently starting or no status available

public int getState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_sendCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getSensorData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getPose = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getOdometer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_resetOdometer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_getStateJson = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
}
// Connects to the robot over the specified Bluetooth device

public void connect(java.lang.String username, java.lang.String robotBtName, java.lang.String robotBtAddr) throws android.os.RemoteException;
// Disconnect from the robot

public void disconnect() throws android.os.RemoteException;
// Sends the specified command string to the robot over Bluetooth

public void sendCommand(java.lang.String cmd) throws android.os.RemoteException;
// Returns the specified sensor data

public byte[] getSensorData(int sensorType) throws android.os.RemoteException;
// Returns pose as a String formatted as "x:y:th"

public java.lang.String getPose() throws android.os.RemoteException;
// Returns cumulative distance and heading as a String formatted as "distance:heading"

public java.lang.String getOdometer(boolean reset) throws android.os.RemoteException;
// Resets the cumulative distance and heading

public void resetOdometer() throws android.os.RemoteException;
// Returns the sensor state of the robot as a JSON string

public java.lang.String getStateJson() throws android.os.RemoteException;
// Checks the state of the controller
// returns 0 - failed connecting to Bluetooth
//         1 - success, and ready to accept messages
//         2 - NONE, i.e. currently starting or no status available

public int getState() throws android.os.RemoteException;
}
