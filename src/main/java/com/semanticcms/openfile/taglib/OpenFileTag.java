/*
 * semanticcms-openfile-taglib - SemanticCMS desktop integration mode for local content creation in a JSP environment.
 * Copyright (C) 2013, 2014, 2015, 2016, 2017, 2020, 2021, 2022, 2024, 2025, 2026  AO Industries, Inc.
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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspTagException;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Opens a file from the servlet container.
 * This opens the file from the server-side so that the proper application
 * may be launched with the local file, allowing direct editing and saving.
 *
 * <p>{@link OpenFile}
 * must be explicitly enabled by setting the <code>com.semanticcms.openfile.servlet.OpenFile.enabled</code>
 * context parameter to <code>true</code>.</p>
 *
 * <p>For security, {@link OpenFile}
 * may only be called from localhost.  However, be careful when behind a proxy,
 * as external proxied requests can appear to come from localhost.</p>
 */
public class OpenFileTag extends SimpleTagSupport {

  private DomainName domain;

  /**
   * Sets the domain of the file to open.
   */
  public void setDomain(String domain) throws ValidationException {
    this.domain = DomainName.valueOf(Strings.nullIfEmpty(domain));
  }

  private Path book;

  /**
   * Sets the book of the file to open.
   */
  public void setBook(String book) throws ValidationException {
    this.book = Path.valueOf(Strings.nullIfEmpty(book));
  }

  private Path path;

  /**
   * Sets the path of the file to open.
   */
  public void setPath(String path) throws ValidationException {
    this.path = Path.valueOf(Strings.nullIfEmpty(path));
  }

  @Override
  public void doTag() throws JspException, IOException {
    try {
      final PageContext pageContext = (PageContext) getJspContext();
      OpenFile.openFile(
          pageContext.getServletContext(),
          (HttpServletRequest) pageContext.getRequest(),
          (HttpServletResponse) pageContext.getResponse(),
          domain,
          book,
          path
      );
    } catch (ServletException e) {
      throw new JspTagException(e);
    }
  }
}
