package test;




import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InquiryServiceImplTest {

	private String ecmsDefaultRecipients = "defaultAddr";
	private String ecmsExternalRecipients = "extAddr";
	
	private InquiryServiceImpl service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service = new InquiryServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		test_getEcmsRecipients();
		test_getMailTemplate();
		test_getAppChangeID();
	}

	private void test_getEcmsRecipients(){
		try {
			DefaultAppUser user = new DefaultAppUser();
			PublicInquiry fm = new PublicInquiry();

			// テストの準備（返すフィールド）
			Field defaultAddr = InquiryServiceImpl.class.getDeclaredField("ecmsDefaultRecipients");
			defaultAddr.setAccessible(true);
			defaultAddr.set(service, ecmsDefaultRecipients);

			Field extAddr = InquiryServiceImpl.class.getDeclaredField("ecmsExternalRecipients");
			extAddr.setAccessible(true);
			extAddr.set(service, ecmsExternalRecipients);
			
			// プライベートメソッド呼び出しの準備
			Method method = InquiryServiceImpl.class.getDeclaredMethod("getEcmsRecipients", AppUser.class, Inquiry.class);
			method.setAccessible(true);
			
			// test
			for (App app: App.values()) {
				user.setAppId(app.getId());
				fm.setGid(app.getId());
				for(Country country: Country.values()) {
					fm.setCountry(country.getValue());
					String addr = (String)method.invoke(service, user, fm);

					if(addr.equals(ecmsExternalRecipients)) {
						System.out.println("AppId:" + app.getId() + ", Country:" + country.getValue() + " --- expected:" + ecmsExternalRecipients + ", actual:" + addr);
					}
					
					// linegamechanneling＠linegamecs.com  に流したい条件
					if ((app.getId().equals("SJLGPP") && (country.getValue().equals("TW") || country.getValue().equals("HK") || country.getValue().equals("MO"))) ||
						(app.getId().equals("LGRGS") && (country.getValue().equals("TW") || country.getValue().equals("HK") || country.getValue().equals("MO") || country.getValue().equals("TH"))) ||
						(app.getId().equals("LGCOOKIE") && (country.getValue().equals("TW") || country.getValue().equals("HK") || country.getValue().equals("MO") || country.getValue().equals("TH"))) ||
						(app.getId().equals("LGMARBLE") && (country.getValue().equals("TH") || country.getValue().equals("BN") || country.getValue().equals("KH") || country.getValue().equals("ID") || country.getValue().equals("LA") || country.getValue().equals("MY") || country.getValue().equals("SG") || country.getValue().equals("VN") )) ||
						(app.getId().equals("LGMARBLE") && (country.getValue().equals("TW"))) ||
						(app.getId().equals("LGWESTOL") && (country.getValue().equals("TW"))) ||
						(app.getId().equals("LGPKPK") && (country.getValue().equals("TW") || country.getValue().equals("TH"))) ||
						(app.getId().equals("LGSWEET") && (country.getValue().equals("TW") || country.getValue().equals("TH"))) ||
						(app.getId().equals("LGBUBBLEF") && (country.getValue().equals("TW") || country.getValue().equals("TH"))) ||
						(app.getId().equals("LGSTAGE") && (country.getValue().equals("TW") || country.getValue().equals("TH"))) ||
						(app.getId().equals("LGANIPANG") && (country.getValue().equals("TW") || country.getValue().equals("TH"))) ||
						(app.getId().equals("LGPSH") && (country.getValue().equals("TW") || country.getValue().equals("TH")))
						) {
						
						Assert.assertEquals( "AppId:" + app.getId() + ", Country:" + country.getValue() + " --- expected:" + ecmsExternalRecipients + ", actual:" + addr , ecmsExternalRecipients, addr);						
					} else {
						Assert.assertEquals( "AppId:" + app.getId() + ", Country:" + country.getValue() + " --- expected:" + ecmsDefaultRecipients + ", actual:" + addr , ecmsDefaultRecipients, addr);
					}					
				}
			}
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	private void test_getMailTemplate() {
		// プライベートメソッド呼び出しの準備
		Method method = null;
		try {
			method = InquiryServiceImpl.class.getDeclaredMethod("getMailTemplate", String.class, String.class);
			method.setAccessible(true);
			Assert.assertEquals("inquiry_reply_ja.vm", (String)method.invoke(service, "inquiry_reply", "ja"));
			Assert.assertEquals("inquiry_reply_ja.vm", (String)method.invoke(service, "inquiry_reply", "JA"));
			Assert.assertEquals("inquiry_reply_ja.vm", (String)method.invoke(service, "inquiry_reply", "Ja"));
			Assert.assertEquals("inquiry_reply_ja.vm", (String)method.invoke(service, "inquiry_reply", "jA"));

			Assert.assertEquals("inquiry_reply_en.vm", (String)method.invoke(service, "inquiry_reply", "en"));
			Assert.assertEquals("inquiry_reply_en.vm", (String)method.invoke(service, "inquiry_reply", "EN"));
			Assert.assertEquals("inquiry_reply_en.vm", (String)method.invoke(service, "inquiry_reply", "En"));
			Assert.assertEquals("inquiry_reply_en.vm", (String)method.invoke(service, "inquiry_reply", "eN"));

			Assert.assertEquals("inquiry_reply_zh-hant.vm", (String)method.invoke(service, "inquiry_reply", "zh-hant"));
			Assert.assertEquals("inquiry_reply_zh-hant.vm", (String)method.invoke(service, "inquiry_reply", "ZH-HANT"));
			Assert.assertEquals("inquiry_reply_zh-hant.vm", (String)method.invoke(service, "inquiry_reply", "Zh-Hant"));
			Assert.assertEquals("inquiry_reply_zh-hant.vm", (String)method.invoke(service, "inquiry_reply", "Zh-Hant"));
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void test_getAppChangeID(){
		Method method = null;
		PublicInquiry testInquiry = new PublicInquiry(){

			@Override
			public String getGid() {
				// TODO Auto-generated method stub
				return "LGTMTM";
			}
			
		};
		
		AppUser user = new AppUser() {
			
			@Override
			public boolean isLoggedIn() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getVersion() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getUserAgent() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public OS getOs() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getMemberId() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getMarketId() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getLang() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getDeviceName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getCountry() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAppId() {
				// TODO Auto-generated method stub
				return "LGTMTM";
			}
		};
		try {
			method = InquiryServiceImpl.class.getDeclaredMethod(
					"getAppIdByInquiryOrAppUser", AppUser.class, Inquiry.class);
			method.setAccessible(true);

			testInquiry.setCountry("JP");
			Assert.assertEquals("LGTMTM",
					(String) method.invoke(service, user, testInquiry));

			testInquiry.setCountry("CN");
			Assert.assertEquals("LGTMTMG",
					(String) method.invoke(service, user, testInquiry));

			testInquiry.setCountry("TD");
			Assert.assertEquals("LGTMTMG",
					(String) method.invoke(service, user, testInquiry));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
}
