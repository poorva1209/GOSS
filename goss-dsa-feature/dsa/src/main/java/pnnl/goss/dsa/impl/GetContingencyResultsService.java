/*
	Copyright (c) 2014, Battelle Memorial Institute
    All rights reserved.
    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions are met:
    1. Redistributions of source code must retain the above copyright notice, this
    list of conditions and the following disclaimer.
    2. Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
    ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
    WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
     
    DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
    ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
    (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
    LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
    ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
    SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
    The views and conclusions contained in the software and documentation are those
    of the authors and should not be interpreted as representing official policies,
    either expressed or implied, of the FreeBSD Project.
    This material was prepared as an account of work sponsored by an
    agency of the United States Government. Neither the United States
    Government nor the United States Department of Energy, nor Battelle,
    nor any of their employees, nor any jurisdiction or organization
    that has cooperated in the development of these materials, makes
    any warranty, express or implied, or assumes any legal liability
    or responsibility for the accuracy, completeness, or usefulness or
    any information, apparatus, product, software, or process disclosed,
    or represents that its use would not infringe privately owned rights.
    Reference herein to any specific commercial product, process, or
    service by trade name, trademark, manufacturer, or otherwise does
    not necessarily constitute or imply its endorsement, recommendation,
    or favoring by the United States Government or any agency thereof,
    or Battelle Memorial Institute. The views and opinions of authors
    expressed herein do not necessarily state or reflect those of the
    United States Government or any agency thereof.
    PACIFIC NORTHWEST NATIONAL LABORATORY
    operated by BATTELLE for the UNITED STATES DEPARTMENT OF ENERGY
    under Contract DE-AC05-76RL01830
*/
package pnnl.goss.dsa.impl;

import pnnl.goss.dsa.DsaActivator;
import pnnl.goss.dsa.GetContingencyResultsSei;
import pnnl.goss.sharedperspective.common.datamodel.ContingencyResultList;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(serviceName="GetContingencyResultsService", 
		portName="ContingencyResultsPort", 
		name="ContingencyResults",
		targetNamespace="http://contingency.ws.dsa.fpgi.pnnl.gov/")
public class GetContingencyResultsService implements GetContingencyResultsSei {

	//private pnnl.goss.dsa.impl.GridOpticsServiceImpl gossService;
	/*
	public GetContingencyResultsService(){
		this.gossService = new GridOpticsServiceImpl();
		this.gossService.setPowerGridName(DsaActivator.getPowergridName());
	}*/
	
	@Override
	public @WebResult(name="contingencyResults")ContingencyResultList getDefaultContingencyResults(@WebParam(name="timestamp")String timestamp) {
		GridOpticsServiceImpl gossService = new GridOpticsServiceImpl();
		gossService.setPowerGridName(DsaActivator.getPowergridName());
		return gossService.getContingencyResults(timestamp);
	}
	
	@Override
	public @WebResult(name="contingencyResults")ContingencyResultList getContingencyResults(@WebParam(name="powerGridName")String powerGridName,
			@WebParam(name="timestamp")String timestamp) {
		GridOpticsServiceImpl gossService = new GridOpticsServiceImpl();
		gossService.setPowerGridName(DsaActivator.getPowergridName());
		return gossService.getContingencyResults(powerGridName, timestamp);
	}
	
	@Override
	public @WebResult(name="latestContingencyResults")ContingencyResultList getLatestDefaultContingencyResults() {
		GridOpticsServiceImpl gossService = new GridOpticsServiceImpl();
		gossService.setPowerGridName(DsaActivator.getPowergridName());
		return gossService.getLatestContingencyResults();
	}

	@Override
	public @WebResult(name="latestContingencyResults")ContingencyResultList getLatestContingencyResults(
			@WebParam(name="powerGridName")String powerGridName) {
		GridOpticsServiceImpl gossService = new GridOpticsServiceImpl();
		gossService.setPowerGridName(DsaActivator.getPowergridName());
		return gossService.getLatestContingencyResults(powerGridName);
	}

}

