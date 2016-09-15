package com.panarquia.backend;

import java.io.Serializable;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "panarquiaApi",
version = "1",
namespace = @ApiNamespace(ownerDomain = "com.panarquia.backend",
    ownerName = "com.panarquia.backend",
    packagePath = ""))
public class YourFirstAPI {
	
	@ApiMethod(path = "say",
		    name = "sayHiUser",
		    httpMethod = ApiMethod.HttpMethod.GET)
	public resp helloWorld() {
		return new resp("seer", "sdafsd");
	}
	
	@ApiMethod(path = "sayHi",
		    name = "sayHiUser",
		    httpMethod = ApiMethod.HttpMethod.GET)
	public resp sayHi() {
		return new resp("seer", "sdafsd");
	}
	

	public class resp implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private String name;
		private String value;

		public resp(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return this.name;
		}

		public String getValue() {
			return this.value;
		}

	}
}
