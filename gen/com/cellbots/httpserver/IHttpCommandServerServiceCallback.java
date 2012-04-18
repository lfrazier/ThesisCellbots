/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\lfrazier\\workspace\\cellbots\\src\\com\\cellbots\\httpserver\\IHttpCommandServerServiceCallback.aidl
 */
package com.cellbots.httpserver;
/**
 * A oneway interface for making callbacks to the client of the service when
 * HTTP requests are received.
 *
 * @author chaitanyag@google.com (Chaitanya Gharpure)
 */
public interface IHttpCommandServerServiceCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.cellbots.httpserver.IHttpCommandServerServiceCallback
{
private static final java.lang.String DESCRIPTOR = "com.cellbots.httpserver.IHttpCommandServerServiceCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.cellbots.httpserver.IHttpCommandServerServiceCallback interface,
 * generating a proxy if needed.
 */
public static com.cellbots.httpserver.IHttpCommandServerServiceCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.cellbots.httpserver.IHttpCommandServerServiceCallback))) {
return ((com.cellbots.httpserver.IHttpCommandServerServiceCallback)iin);
}
return new com.cellbots.httpserver.IHttpCommandServerServiceCallback.Stub.Proxy(obj);
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
case TRANSACTION_OnRequest:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String[] _arg1;
int _arg1_length = data.readInt();
if ((_arg1_length<0)) {
_arg1 = null;
}
else {
_arg1 = new java.lang.String[_arg1_length];
}
java.lang.String[] _arg2;
int _arg2_length = data.readInt();
if ((_arg2_length<0)) {
_arg2 = null;
}
else {
_arg2 = new java.lang.String[_arg2_length];
}
byte[] _arg3;
int _arg3_length = data.readInt();
if ((_arg3_length<0)) {
_arg3 = null;
}
else {
_arg3 = new byte[_arg3_length];
}
this.OnRequest(_arg0, _arg1, _arg2, _arg3);
reply.writeStringArray(_arg1);
reply.writeStringArray(_arg2);
reply.writeByteArray(_arg3);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.cellbots.httpserver.IHttpCommandServerServiceCallback
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
// This method is called when a PUT/POST request is made to the HTTP server.
// @param request The name of the resource requested
// @param keys An array of keys of all URL parameters
// @param values An array of values of all URL parameters
// @param data the data sent as an entity with the PUT/POST request

public void OnRequest(java.lang.String request, java.lang.String[] keys, java.lang.String[] values, byte[] data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(request);
if ((keys==null)) {
_data.writeInt(-1);
}
else {
_data.writeInt(keys.length);
}
if ((values==null)) {
_data.writeInt(-1);
}
else {
_data.writeInt(values.length);
}
if ((data==null)) {
_data.writeInt(-1);
}
else {
_data.writeInt(data.length);
}
mRemote.transact(Stub.TRANSACTION_OnRequest, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_OnRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
// This method is called when a PUT/POST request is made to the HTTP server.
// @param request The name of the resource requested
// @param keys An array of keys of all URL parameters
// @param values An array of values of all URL parameters
// @param data the data sent as an entity with the PUT/POST request

public void OnRequest(java.lang.String request, java.lang.String[] keys, java.lang.String[] values, byte[] data) throws android.os.RemoteException;
}
