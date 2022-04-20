/*
 * semanticcms-openfile-taglib - SemanticCMS desktop integration mode for local content creation in a JSP environment.
 * Copyright (C) 2013, 2014, 2015, 2016, 2017, 2020, 2021, 2022  AO Industries, Inc.
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

package com.semanticcms.openfile.taglib;

import com.aoapps.lang.Strings;
import com.aoapps.lang.validation.ValidationException;
import com.aoapps.net.DomainName;
import com.aoapps.net.Path;
import com.semanticcms.openfile.servlet.OpenFile;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OpenFileTag extends SimpleTagSupport {

  private DomainName domain;
  public void setDomain(String domain) throws ValidationException {
    this.domain = DomainName.valueOf(Strings.nullIfEmpty(domain));
  }

  private Path book;
  public void setBook(String book) throws ValidationException {
    this.book = Path.valueOf(Strings.nullIfEmpty(book));
  }

  private Path path;
  public void setPath(String path) throws ValidationException {
    this.path = Path.valueOf(Strings.nullIfEmpty(path));
  }

  @Override
  public void doTag() throws JspException, IOException {
    try {
      final PageContext pageContext = (PageContext)getJspContext();
      OpenFile.openFile(
        pageContext.getServletContext(),
        (HttpServletRequest)pageContext.getRequest(),
        (HttpServletResponse)pageContext.getResponse(),
        domain,
        book,
        path
      );
    } catch (ServletException e) {
      throw new JspTagException(e);
    }
  }
}
