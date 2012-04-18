/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\lfrazier\\workspace\\cellbots\\src\\com\\cellbots\\httpserver\\IHttpCommandServerService.aidl
 */
package com.cellbots.httpserver;
/**
 * Interface for the HTTP command server service.
 * @author chaitanyag@google.com (Chaitanya Gharpure)
 */
public interface IHttpCommandServerService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.cellbots.httpserver.IHttpCommandServerService
{
private static final java.lang.String DESCRIPTOR = "com.cellbots.httpserver.IHttpCommandServerService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.cellbots.httpserver.IHttpCommandServerService interface,
 * generating a proxy if needed.
 */
public static com.cellbots.httpserver.IHttpCommandServerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.cellbots.httpserver.IHttpCommandServerService))) {
return ((com.cellbots.httpserver.IHttpCommandServerService)iin);
}
return new com.cellbots.httpserver.IHttpCommandServerService.Stub.Proxy(obj);
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
case TRANSACTION_setResponseDataByName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
java.lang.String _arg2;
_arg2 = data.readString();
this.setResponseDataByName(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setResponsePathByName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.setResponsePathByName(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getResponseByName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _result = this.getResponseByName(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_setRoot:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setRoot(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_stopServer:
{
data.enforceInterface(DESCRIPTOR);
this.stopServer();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.cellbots.httpserver.IHttpCommandServerService
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
// Sets the response data for a named resource as a byte array.
// @param name the name of the resource whose value to set
// @param data the data value of the resource
// @param contentType The content type of the resource which is sent back
//     in the HTTP response  

public void setResponseDataByName(java.lang.String name, byte[] data, java.lang.String contentType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeByteArray(data);
_data.writeString(contentType);
mRemote.transact(Stub.TRANSACTION_setResponseDataByName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Sets the path of the named resource which could be the path of a file
// on the SD card.
// @param name the name of the resource whose value to set
// @param resource the path to the resource file
// @param contentType The content type of the resource which is sent back
//     in the HTTP response  

public void setResponsePathByName(java.lang.String name, java.lang.String resource, java.lang.String contentType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(resource);
_data.writeString(contentType);
mRemote.transact(Stub.TRANSACTION_setResponsePathByName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Returns the value of the named resource as a byte array.
// @param name the name of the resource to retrieve
// @return the data value of the resource as a byte array

public byte[] getResponseByName(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_getResponseByName, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Sets the root directory where to look up resource files.

public void setRoot(java.lang.String root) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(root);
mRemote.transact(Stub.TRANSACTION_setRoot, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Stops the HTTP server.

public void stopServer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopServer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_setResponseDataByName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_setResponsePathByName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getResponseByName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setRoot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_stopServer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
// Sets the response data for a named resource as a byte array.
// @param name the name of the resource whose value to set
// @param data the data value of the resource
// @param contentType The content type of the resource which is sent back
//     in the HTTP response  

public void setResponseDataByName(java.lang.String name, byte[] data, java.lang.String contentType) throws android.os.RemoteException;
// Sets the path of the named resource which could be the path of a file
// on the SD card.
// @param name the name of the resource whose value to set
// @param resource the path to the resource file
// @param contentType The content type of the resource which is sent back
//     in the HTTP response  

public void setResponsePathByName(java.lang.String name, java.lang.String resource, java.lang.String contentType) throws android.os.RemoteException;
// Returns the value of the named resource as a byte array.
// @param name the name of the resource to retrieve
// @return the data value of the resource as a byte array

public byte[] getResponseByName(java.lang.String name) throws android.os.RemoteException;
// Sets the root directory where to look up resource files.

public void setRoot(java.lang.String root) throws android.os.RemoteException;
// Stops the HTTP server.

public void stopServer() throws android.os.RemoteException;
}
