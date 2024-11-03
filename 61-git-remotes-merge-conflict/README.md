# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
2. Ci si assicuri di avere localmente entrambi i branch remoti
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
8. Si faccia push del branch `master` sul proprio repository
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

------------------------------------------------------------------------------------------

$ git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git merge-solution
Cloning into 'merge-solution'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.

$ cd merge-solution/

$ git remote -v
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)

$ git branch -v
* master 8e0f29c Change HelloWorld to print the number of available processors

$ git checkout -b feature origin/feature
branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'

$ git branch -a
* feature
  master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

$ git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.

$ git merge feature 
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

-----------------------------------------------------------------------------------------
public final class HelloWorld {

	private static final String AUTHOR = "Danilo Pianini";

	public static void main(final String[] args) {
		System.out.println("This program is running in a PC with " + procNumber() + " logic processors!");
	}

	public static int procNumber() {
		System.out.println("This program has been realised by " + AUTHOR);
		return Runtime.getRuntime().availableProcessors();
	}

}
----------------------------------------------------------------------------------------


$ git remote add new-origin https://github.com/Jujez04/OOP-git-merge-conflict-solution.git

$ git remote remove origin

$ git remote -v
new-origin      https://github.com/Jujez04/OOP-git-merge-conflict-solution.git (fetch)
new-origin      https://github.com/Jujez04/OOP-git-merge-conflict-solution.git (push)

$ git push
fatal: The current branch master has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream new-origin master

To have this happen automatically for branches without a tracking
upstream, see 'push.autoSetupRemote' in 'git help config'.

$ git push --set-upstream new-origin master
branch 'master' set up to track 'new-origin/master'.
Everything up-to-date

$ git add -A

$ git commit -m "Merge conflict in HelloWorld.java resolved"
[master dbe7d62] Merge conflict in HelloWorld.java resolved

$ git log --all --graph --oneline
*   dbe7d62 (HEAD -> master, new-origin/master) Merge conflict in HelloWorld.java resolved
|\
| * bed943f (feature) Print author information
* | 8e0f29c Change HelloWorld to print the number of available processors
|/
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld
