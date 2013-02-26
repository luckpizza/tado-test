package tado.test

import groovyx.net.http.*
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

class ReportGitHubIssueController {
	
	static BASIC_AUTHENTICATION =  "bHVja3BpenphLXRlc3Q6dGVzdDEyMzQ="
	static BASE_URI = "https://api.github.com"
	static REPO_PATH = '/repos/luckpizza/tado-test/issues'
	def create() {

		def http = new HTTPBuilder(BASE_URI)
		http.setHeaders( [Authorization: "Basic " + BASIC_AUTHENTICATION])
		http.uri.path = REPO_PATH
		http.request(Method.POST, "application/json", {
			body =  [title:params."title", body:params."body"]
			response.success = { resp, reader ->
				println "Success! ${resp.status}"
				println reader 
			}
			response.failure = { resp, reader ->
				println "Request failed with status ${resp.status}"
				println reader
			}
		})
	}
}
