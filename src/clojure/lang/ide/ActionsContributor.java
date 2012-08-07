/*******************************************************************************
 * Copyright (c) 2009-2012 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   * Jurgen J. Vinju - Jurgen.Vinju@cwi.nl - CWI
 *   * Arnold Lankamp - Arnold.Lankamp@cwi.nl
 *   * Michael Steindorfer - Michael.Steindorfer@cwi.nl - CWI
*******************************************************************************/
package clojure.lang.ide;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.services.ILanguageActionsContributor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;

public class ActionsContributor implements ILanguageActionsContributor {

	@Override
	public void contributeToEditorMenu(UniversalEditor editor,
			IMenuManager menuManager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contributeToToolBar(final UniversalEditor editor,
			IToolBarManager toolbarManager) {
		
	}

	@Override
	public void contributeToStatusLine(UniversalEditor editor,
			IStatusLineManager statusLineManager) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	@Override
	public void contributeToMenuBar(UniversalEditor editor, IMenuManager menu) {
		ISourceProject sourceProject = editor.getParseController().getProject();

		if (sourceProject != null) {
			IProject rawProject = sourceProject.getRawProject();
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(rawProject.getFullPath().append(editor.getParseController().getPath()));

//			IMenuManager rascalMenu = menu.findMenuUsingPath("rascal");
//			if (rascalMenu == null) {
//				rascalMenu = new MenuManager("Rascal","rascal");
//				menu.add(rascalMenu);
//			}
//			
//			rascalMenu.add(new LaunchConsoleAction(rawProject, file));
//			rascalMenu.add(new RunAmbiDexter(editor, rawProject, file));
//			rascalMenu.add(new ListAmbiguities(editor, rawProject, file)); 
//			rascalMenu.add(new CopyToConsole(editor));		
		}
	}

}
