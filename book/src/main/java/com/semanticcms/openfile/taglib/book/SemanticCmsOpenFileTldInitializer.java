/*
 * semanticcms-openfile-taglib - SemanticCMS desktop integration mode for local content creation in a JSP environment.
 * Copyright (C) 2016  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-openfile-taglib.
 *
 * semanticcms-openfile-taglib is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-openfile-taglib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-openfile-taglib.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.semanticcms.openfile.taglib.book;

import com.semanticcms.tagreference.TagReferenceInitializer;
import java.util.Collections;

/**
 * @author  AO Industries, Inc.
 */
public class SemanticCmsOpenFileTldInitializer extends TagReferenceInitializer {

	public SemanticCmsOpenFileTldInitializer() {
		super(
			"OpenFile Taglib Reference",
			"Taglib Reference",
			"/openfile/taglib",
			"/semanticcms-openfile.tld",
			"https://docs.oracle.com/javase/6/docs/api/",
			"https://docs.oracle.com/javaee/6/api/",
			Collections.singletonMap("com.semanticcms.openfile.taglib.", "https://semanticcms.com/openfile/taglib/apidocs/")
		);
	}
}