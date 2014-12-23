// getting all soapui requests
def soapuiRequests = testRunner.testCase.getTestStepsOfType(com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep)

// loop through each requests
soapuiRequests.each {
    // creating directory name from request path
    // TODO getting request path
    // it.getProperty("requestUri")) or it.getHttpRequest().getEndpoint()
    def requestPath = "?"
    def inputFileRequest = new File(requestPath + "/request.xml")
    def inputFileResponse = new File(requestPath + "/response.xml")
    // writing request to request.xml file
    inputFileRequest.write(context.testCase.getTestStepByName(it.name).getProperty("request").value)
    // writing response to response.xml file
    inputFileResponse.write(context.testCase.getTestStepByName(it.name).getProperty("response").value)
}