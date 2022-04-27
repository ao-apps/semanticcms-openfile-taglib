/*
 * semanticcms-openfile-taglib - SemanticCMS desktop integration mode for local content creation in a JSP environment.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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
 * along with semanticcms-openfile-taglib.  If not, see <https://www.gnu.org/licenses/>.
 */
module com.semanticcms.openfile.taglib {
  exports com.semanticcms.openfile.taglib;
  // Direct
  requires com.aoapps.lang; // <groupId>com.aoapps</groupId><artifactId>ao-lang</artifactId>
  requires javax.servlet.api; // <groupId>javax.servlet</groupId><artifactId>javax.servlet-api</artifactId>
  requires javax.servlet.jsp.api; // <groupId>javax.servlet.jsp</groupId><artifactId>javax.servlet.jsp-api</artifactId>
  requires com.semanticcms.openfile.servlet; // <groupId>com.semanticcms</groupId><artifactId>semanticcms-openfile-servlet</artifactId>
} // TODO: Avoiding rewrite-maven-plugin-4.22.2 truncation
