package edu.ucdenver.ccp.datasource.fileparsers.pharmgkb;

/*
 * #%L
 * Colorado Computational Pharmacology's common module
 * %%
 * Copyright (C) 2012 - 2015 Regents of the University of Colorado
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the Regents of the University of Colorado nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */


import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.Collection;

import lombok.Data;
import edu.ucdenver.ccp.datasource.fileparsers.License;
import edu.ucdenver.ccp.datasource.fileparsers.Record;
import edu.ucdenver.ccp.datasource.fileparsers.RecordField;
import edu.ucdenver.ccp.datasource.fileparsers.SingleLineFileRecord;
import edu.ucdenver.ccp.datasource.identifiers.DataSource;
import edu.ucdenver.ccp.datasource.identifiers.DataSourceIdentifier;
import edu.ucdenver.ccp.datasource.identifiers.pharmgkb.PharmGkbID;

/**
 * File record capturing single line record from PharmGKB's drugs.tsv file.
 * 
 * @author Yuriy Malenkiy
 * 
 */
@Record(dataSource = DataSource.PHARMGKB,
		license=License.PHARMGKB,
		licenseUri="http://www.pharmgkb.org/download.action?filename=PharmGKB_License.pdf",
		comment="data from PharmGKB's drugs.tsv file",
		citation="M. Whirl-Carrillo, E.M. McDonagh, J. M. Hebert, L. Gong, K. Sangkuhl, C.F. Thorn, R.B. Altman and T.E. Klein. \"Pharmacogenomics Knowledge for Personalized Medicine\" Clinical Pharmacology & Therapeutics (2012) 92(4): 414-417",
		label="drug record")
@Data
public class PharmGkbDrugFileRecord extends SingleLineFileRecord {
	@RecordField
	private PharmGkbID accessionId;
	@RecordField
	private final String name;
	@RecordField
	private Collection<String> genericNames;
	@RecordField
	private Collection<String> tradeNames;
	@RecordField
	private Collection<String> brandMixtures;
	@RecordField
	private final String type;
	@RecordField
	private Collection<DataSourceIdentifier<?>> crossReferences;
	@RecordField
	private final String url;
	@RecordField
	private final String smiles;
	@RecordField
	private final String dosingGuideline;
	@RecordField
	private final String externalVocabulary;

	public PharmGkbDrugFileRecord(String pharmGkbAccessionId, String name, Collection<String> genericNames,
			Collection<String> tradeNames, Collection<String> brandMixtures, String type,
			Collection<DataSourceIdentifier<?>> crossReferences, String url, String smiles, String dosingGuideline,String externalVocabulary,
			long byteOffset, long lineNumber) {
		super(byteOffset, lineNumber);
		this.url = isNotBlank(url) ? url : null;
		this.accessionId = new PharmGkbID(pharmGkbAccessionId);
		this.name = isNotBlank(name) ? name : null;
		this.genericNames = genericNames;
		this.tradeNames = tradeNames;
		this.brandMixtures = brandMixtures;
		this.type = type;
		this.crossReferences = crossReferences;
		this.smiles = isNotBlank(smiles) ? smiles : null;
		this.dosingGuideline = isNotBlank(dosingGuideline) ? dosingGuideline : null;
		this.externalVocabulary = isNotBlank(externalVocabulary) ? externalVocabulary : null;
	}

	

}
