package tado.test

import groovyx.net.http.*
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

class ReportGitHubIssueController {
	
	def create() {

		def http = new HTTPBuilder("https://api.github.com")
		http.auth.basic "luckpizza-test", "test1234"
		http.uri.path = '/repos/luckpizza/tado-test/issues'
		http.request(Method.GET) {
//			uri.path = '/repos/luckpizza/tado-test/issues'
//			requestContentType = ContentType.URLENC
			
			response.success = { resp, reader ->
				println "Success! ${resp.status}"
				println reader 
			}
		
			response.failure = { resp ->
				println "Request failed with status ${resp.status}"
				
			}
		}
		println "whatever "
		println params
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//		withRest(uri: "https://api.github.com") {
	//			auth.basic "luckpizza-test", "test1234"
	//			post(path : '/repos/luckpizza/tado-test/issues',
	//				body: "", requestContentType : URLENC )
	//			println response.status
	
		
//	def create() {
//
//		withRest(uri: "https://api.github.com") {
//			auth.basic "luckpizza-test", "test1234"
//			post(path : '/repos/luckpizza/tado-test/issues',
//					body: "", requestContentType : URLENC )
//			println response.status
//		}
//		println "whatever "
//		println params
//	}
}
