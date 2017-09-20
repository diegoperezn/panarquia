package com.panarquia.api.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/visa")
public class CheckVisa {

	private String url = "curl 'https://onlineservices.immigration.govt.nz/PaymentGateway/OnLinePayment.aspx?ProductId=2&SourceUrl=%2f%2fonlineservices.immigration.govt.nz%2fWorkingHoliday%2fApplication%2fSubmitConfirmation.aspx%3fApplicationId%3d1935595&Token=LctQ9Y5g+5WanrJmA6S2WfJosX2EAYHGE7eJRKJRsI%2fZehNcgvOibKbiLLg744ZSOVoAu%2frez90%3d' -H 'Cookie: RanId=357517119; BIGipServer~Public~vs-onlinechannel2.ext.wd.govt.nz_443.app~vs-onlinechannel2.ext.wd.govt.nz_443_pool=rd1906o00000000000000000000ffff0ae82283o80; __RequestVerificationToken=Uxguula3Z23Np1bJSVGZe20N5oHHNBlr7GNKtmCeXgkNdrB376E33Y_j81vPoD6q5s6-HDVAz-qLuKNBN1rvdxZLT341; ASP.NET_SessionId=pctztmwyng0mcwtctlsxmvak; NZIS_CSSMCookieData=PageHistory=/wEWBQUrJTJmQ1NTTSUyZldpemFyZCUyZlByaW1hcnlFbmdsaXNoUGFydDMuYXNweAUxJTJmQ1NTTSUyZldpemFyZCUyZlN1bW1hcnkuYXNweCUzZkVPSUlEJTNkMTQ0NDYxNgUnJTJmQ1NTTSUyZldpemFyZCUyZlByaW1hcnlDaGlsZHJlbi5hc3B4BSolMmZDU1NNJTJmV2l6YXJkJTJmUHJpbWFyeU90aGVyRmFtaWx5LmFzcHgFKSUyZkNTU00lMmZXaXphcmQlMmZQcmltYXJ5QXNzaXN0ZWRCeS5hc3B4&EOIID=1444616&DisplayMandatoryFieldErrorMessages=False; _ga=GA1.3.1236919676.1505173178; _gid=GA1.3.1574629585.1505683632; TSPD_101=08819c2a25ab280060b1f3a353e4959950d0d20bae39a1749202114f6323ec692cc8f799520a4db0b23b0a4ebb2e9a2608e9c123bb0510007871a8ab86914e949483047df012ed90:; ImmigrationAuth=BBECC2D8E16306DC046908E3796E5ACB34614FD0C055029D73F7BA7733E39DD4E3E5682CACB406973F4152A0EA5FE58FCCA0890329817D8588C85F6996A582AACEBCF6BFDAB34E4ACF0315A359EA68AB2A729CDCC97EB77CDCAB60FC4BF8125016F1C02D3E363034991498162C9EA63A636FA0923464528704A41CC2DDE4F9D4CC5A8CF348652A58F0A477FC3C7E6322CCDF9A7CFF54814F42DC8CCF7667391D8BA3BFC1651AD23576EF2DBA844D5613C8F943ED4076B29A497B706F33F004C459AEB9EB79222AA3D03FB7CB855C47C26FB124B57F9537F0CA4289A5E7D275688A1EB118CF7B61928F3364846D1347F05E4FC4871609CDDA4AF8DB0FBCBE29C62A715C1E43EE145398776AE892F119CC01F7060E779424890913BD8CBA1390BE2C5F4DC787041B49332FAA8AC18642E4237C5578F1435139E2CF58BD619F70258DC9C65AE0A8A45972AC5DF0ED4675A964298CA9D152D826BA5002F8F9DF68A6C441924604D91E5728FDF1919B3B4641D6EBA01CA31B5738934D893B1B89F18F25C73C86C1BA305F35335B983E4D0B47E3E57C43A76008519514850D28DD03583708CC53BDACF4801E05759D5412BC37AD775A7EBE85CD7FE7AA72BEDC2843D9D8F08AF1; NZISWorkingHolidayData=PageHistory=/wEWBQV2JTJmV29ya2luZ0hvbGlkYXklMmZXaXphcmQlMmZQZXJzb25hbDEuYXNweCUzZkFwcGxpY2F0aW9uSWQlM2QxOTI4MzA2JTI2SW5kaXZpZHVhbFR5cGUlM2RQcmltYXJ5JTI2SW5kaXZpZHVhbEluZGV4JTNkMQUgJTJmV29ya2luZ0hvbGlkYXklMmZkZWZhdWx0LmFzcHgFkQElMmZXb3JraW5nSG9saWRheSUyZkFwcGxpY2F0aW9uJTJmUGF5LmFzcHglM2ZUb2tlbiUzZExjdFE5WTVnJTI1MmI1V2FuckptQTZTMldmSm9zWDJFQVlIR0U3ZUpSS0pSc0klMjUyZlplaE5jZ3ZPaWJLYmlMTGc3NDRaU09Wb0F1JTI1MmZyZXo5MCUyNTNkBZ8CJTJmUGF5bWVudEdhdGV3YXklMmZPbkxpbmVQYXltZW50LmFzcHglM2ZQcm9kdWN0SWQlM2QyJTI2U291cmNlVXJsJTNkJTJmJTJmb25saW5lc2VydmljZXMuaW1taWdyYXRpb24uZ292dC5ueiUyZldvcmtpbmdIb2xpZGF5JTJmQXBwbGljYXRpb24lMmZTdWJtaXRDb25maXJtYXRpb24uYXNweCUzZkFwcGxpY2F0aW9uSWQlM2QxOTM1NTk1JTI2VG9rZW4lM2RMY3RROVk1ZyUyYjVXYW5ySm1BNlMyV2ZKb3NYMkVBWUhHRTdlSlJLSlJzSSUyZlplaE5jZ3ZPaWJLYmlMTGc3NDRaU09Wb0F1JTJmcmV6OTAlM2QFswIlMmZQYXltZW50R2F0ZXdheSUyZk9uTGluZVBheW1lbnQuYXNweCUzZlByb2R1Y3RJZCUzZDIlMjZTb3VyY2VVcmwlM2QlMjUyZiUyNTJmb25saW5lc2VydmljZXMuaW1taWdyYXRpb24uZ292dC5ueiUyNTJmV29ya2luZ0hvbGlkYXklMjUyZkFwcGxpY2F0aW9uJTI1MmZTdWJtaXRDb25maXJtYXRpb24uYXNweCUyNTNmQXBwbGljYXRpb25JZCUyNTNkMTkzNTU5NSUyNlRva2VuJTNkTGN0UTlZNWclMmI1V2FuckptQTZTMldmSm9zWDJFQVlIR0U3ZUpSS0pSc0klMjUyZlplaE5jZ3ZPaWJLYmlMTGc3NDRaU09Wb0F1JTI1MmZyZXo5MCUyNTNk&DisplayMandatoryFieldErrorMessages=False&PaymentGateWay_SourceUrl=//onlineservices.immigration.govt.nz/WorkingHoliday/Application/SubmitConfirmation.aspx?ApplicationId=1935595&PaymentGateWay_Token=LctQ9Y5g 5WanrJmA6S2WfJosX2EAYHGE7eJRKJRsI/ZehNcgvOibKbiLLg744ZSOVoAu/rez90=&PaymentGateWay_ApplicationID=1935595&PaymentGateWay_ProductID=2; TS013d8ed5=0105b6b7b65874f1631694dcc79c50c9e72d6874026d4543ab2ad93a29c772145b78dad8b38a03a76a93f7d4c5ecd2f3efddc8c00f9fb48c4e70c603b98312ab3210fb9bf00b953ec5ad2381d77c477b0cd565df8b5c368de588078fa7f55e69bf59bae9764c1d069a72723d87a77a1ec4bcd57622185eefc6dde7bd24a8890d05d555a3358b4136d0202bd9f4efd58f6cde11b99f' -H 'Origin: https://onlineservices.immigration.govt.nz' -H 'Accept-Encoding: gzip, deflate, br' -H 'Accept-Language: en-US,en;q=0.8' -H 'Upgrade-Insecure-Requests: 1' -H 'User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36' -H 'Content-Type: application/x-www-form-urlencoded' -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8' -H 'Cache-Control: max-age=0' -H 'Referer: https://onlineservices.immigration.govt.nz/PaymentGateway/OnLinePayment.aspx?ProductId=2&SourceUrl=%2f%2fonlineservices.immigration.govt.nz%2fWorkingHoliday%2fApplication%2fSubmitConfirmation.aspx%3fApplicationId%3d1935595&Token=LctQ9Y5g+5WanrJmA6S2WfJosX2EAYHGE7eJRKJRsI%2fZehNcgvOibKbiLLg744ZSOVoAu%2frez90%3d' -H 'Connection: keep-alive' --data '__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=t8HcZOxsItMxOS6PSWYAHoPJOeLR6NllxzEEBs285W%2BSqXJZeNHHIcM2WsnJZD8UN9yfbazXJ%2FB63vGdAYwcp20Ls5pSKf2uYhqX2BqXeS9H0Z%2BpFIsOf7GzBOAoQi2LBWXR2IAfNWS%2BNaf1lFOQSH8amP0%3D&__VIEWSTATEGENERATOR=64EC2CD5&__EVENTVALIDATION=wTrf%2B9n16V2D7fsWAM4xoBOL1wbVSyOAoZvuGMtpmIzjfkYd2Px%2Fnr5oiGHCr9TEMvkWXmiShzb2pcwSgFu8pPnc0i5Dxnjfd%2BHDdxwtwa3t3SeNvIN1ipKIa5BVJsdUxjGfCkCVfMlMtWEzqIBh42RCIjQ%3D&_ctl0%3AContentPlaceHolder1%3ApayerNameTextBox=Eliana&_ctl0%3AContentPlaceHolder1%3AokButton=OK' --compressed";

	// @Scheduled(initialDelay = 1000, fixedDelay = 5000)
	@RequestMapping(method = RequestMethod.GET)
	public String check() {
		boolean matches = false;
		
		try {
			Runtime runtime = Runtime.getRuntime();

			Process process;
			process = runtime.exec(url);

			String page = IOUtils.toString(process.getInputStream());

			String patternString = "Scheme unavailable because: Unfortunately";

			Pattern pattern = Pattern.compile(patternString);

			Matcher matcher = pattern.matcher(page);

			 matches = matcher.find();
		} catch (Exception e) {
			return e.getMessage();
		}
		

		return String.valueOf(matches);
	}

}
