package com.windowsazure.messaging;

/**
 * 
 * Class representing a native registration for a device using APNs.
 *
 */
public class AppleRegistration extends Registration {
	private static final String APNS_NATIVE_REGISTRATION1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><entry xmlns=\"http://www.w3.org/2005/Atom\"><content type=\"application/xml\"><AppleRegistrationDescription xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.microsoft.com/netservices/2010/10/servicebus/connect\">";
	private static final String APNS_NATIVE_REGISTRATION2 = "<DeviceToken>";
	private static final String APNS_NATIVE_REGISTRATION3 = "</DeviceToken></AppleRegistrationDescription></content></entry>";
    
	
	protected String deviceToken;
	
	
	
	public AppleRegistration() {
		super();
	}

	public AppleRegistration(String deviceToken) {
		super();
		this.deviceToken = deviceToken;
	}

	public AppleRegistration(String registrationId, String deviceToken) {
		super(registrationId);
		this.deviceToken = deviceToken;
	}

	public String getDeviceToken() {
		return deviceToken;
	}



	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}



	@Override
	public String getXml() {
		StringBuffer buf = new StringBuffer();
		buf.append(APNS_NATIVE_REGISTRATION1);
		buf.append(getTagsXml());
		buf.append(APNS_NATIVE_REGISTRATION2);
		buf.append(deviceToken);
		buf.append(APNS_NATIVE_REGISTRATION3);
		return buf.toString();
	}

}
