# Contributing to iText

We'd love for you to contribute to our source code and to make iText even better than it is
today! Here are the guidelines we'd like you to follow:

 - [Question or Problem?](#question)
 - [Issues and Bugs](#issue)
 - [New Features](#feature)
 - [Submission Guidelines](#submit)
 - [Coding Rules](#rules)
 - [Commit Message Guidelines](#commit)
 - [Signing the iCLA](#cla)
 - [Contributor Code of Conduct](#coc)


## <a name="question">Got a Question or Problem?</a>

If you have questions about how to use iText, please direct these to [StackOverflow][stackoverflow].

If you are a customer with a [support agreement][support], you also have direct access to our JIRA and our developers.


## <a name="issue">Found an Issue?</a>
If you find a bug in the source code or a mistake in the documentation, you can help us by
submitting a [Pull Request][pull] with a fix.

**Please see the [Submission Guidelines](#submit) below**.


## <a name="feature">Want to implement a Feature?</a>
If you would like to implement a new feature then consider what kind of change it is:

* **Major Changes** that you wish to contribute to the project should be discussed first so that we can better
coordinate our efforts, prevent duplication of work, and help you to craft the change so that it is successfully
accepted into the project.
* **Small Changes** can be crafted and submitted to the [GitHub Repository][github] as a [Pull Request][pull].


## <a name="submit">Submission Guidelines</a>

### Submitting a Question or an Issue
Before you submit your question or issue, search [Stack Overflow][stackoverflow], maybe your question was already answered.

If your issue appears to be a bug, and hasn't been reported, ask a question on [Stack Overflow][stackoverflow].
Help us to maximize the effort we can spend fixing issues and adding new
features, by not reporting duplicate issues. Providing the following information will increase the
chances of your issue being dealt with quickly:

* **[How to ask good questions][good-questions]**
* **Overview of the Issue** - if an error is being thrown a non-minified stack trace helps
* **Motivation for or Use Case** - explain why this is a bug for you
* **iText Version(s)** - is it a regression?
* **Operating System** - is this a problem on Windows or Linux, maybe on Mac?
* **Reproduce the Error** - provide a [Short, Self Contained, Correct (Compilable), Example][sscce], also known as a [Minimal, Complete, and Verifiable example][mcve].
* **Related Issues** - has a similar issue been reported before?
* **Suggest a Fix** - if you can't fix the bug yourself, perhaps you can point to what might be
  causing the problem (line of code or commit)
* **Tag the question** - add the tag 'itext' to your question so we can find it.

**If you get help, help others. Good karma rulez!**


### Submitting a Pull Request
Before you submit your pull request consider the following guidelines:

* Search [GitHub][pull] for an open or closed Pull Request
  that relates to your submission. You don't want to duplicate effort.
* Verify that your proposed change hasn't already been addressed in the develop branch.
* Don't send a separate pull request for every single file you change.  
* Please sign the [iText Contributor License Agreement (iCLA)](#cla) before sending pull
  requests for any change of more than 20 significant lines of code (we're not counting curly braces and other syntactical sugar).
  We cannot accept code without this agreement.
* Clone iText to your local machine.

     ```shell
     git clone git@github.com:itext/itextpdf.git
     cd itextpdf
     git fetch origin
     git checkout -b develop origin/develop
     ```

* Make your changes in a new git branch based off the develop branch:

     ```shell
     git checkout -b my-fix-branch develop
     ```

* Create your patch, **including appropriate test cases**.
* Follow our [Coding Rules](#rules).
* Run the full iText test suite and ensure that all tests pass.
* Commit your changes using a descriptive commit message that follows our
  [commit message conventions](#commit-message-format).

     ```shell
     git commit -a
     ```
  Note: the optional commit `-a` command line option will automatically `add` and `rm` edited files.

* Now would be a good time to fix up your commits (if you want or need to) with `git rebase --interactive`. 
* Build your changes locally to ensure all the tests pass.
* Push your branch to your GitHub account:

    ```shell
    git remote add my-remote git@github.com:my-remote/itextpdf.git
    git push my-remote my-fix-branch
    ```

* In GitHub, send a pull request to `itextpdf:develop`.
* If we suggest changes then:
  * Make the required updates.
  * Re-run the iText test suite to ensure tests are still passing.
  * Rebase your branch and force push to your GitHub repository (this will update your Pull Request):

    ```shell
    git fetch origin
    git rebase develop -i
    git push my-remote my-fix-branch -f
    ```

That's it! Thank you for your contribution!

#### After your pull request is merged

After your pull request is merged, you can safely delete your branch and pull the changes
from the main (upstream) repository:

* Delete the remote branch on GitHub either through the GitHub web UI or your local shell as follows:

    ```shell
    git push my-remote --delete my-fix-branch
    ```

* Check out the develop branch:

    ```shell
    git checkout develop -f
    ```

* Delete the local branch:

    ```shell
    git branch -D my-fix-branch
    ```

* Update your develop with the latest upstream version:

    ```shell
    git pull --ff upstream develop
    ```


## <a name="rules">Coding Rules</a>
To ensure consistency throughout the source code, keep these rules in mind as you are working:

* All features or bug fixes **must be tested** by one or more [unit tests][unit-testing].
* All public API methods **must be documented** with JavaDoc. To see how we document our APIs, please check
  out the existing [javadocs][javadocs].
* We follow the rules contained in
  [Oracle's Code Conventions for the Java Programming Language][java-style-guide], with these additions:
    * Wrap all code at **100 characters**.


## <a name="commit">Git Commit Guidelines</a>

We have very precise rules over how our git commit messages can be formatted. This leads to **more
readable messages** that are easy to follow when looking through the **project history**. But also,
we use the git commit messages to **generate the iText change log**.

### Commit Message Format
Each commit message consists of a **subject**, a **body** and a **footer**:

```
<subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

Any line of the commit message cannot be longer 70 characters! This allows the message to be easier
to read on GitHub as well as in various git tools.

### Subject
The subject contains succinct description of the change:

* use the imperative, present tense: "change" not "changed" nor "changes"
* don't capitalize first letter
* no dot (.) at the end
* describe what the **change** does, not the actions the developer has done

### Body
Just as in the **subject**, use the imperative, present tense: "change" not "changed" nor "changes".
The body should include the motivation for the change and contrast this with previous behavior.

### Footer
The footer should contain any information about **Breaking Changes** and is also the place to
reference JIRA or GitHub issues that this commit **Closes**.


## <a name="cla">Signing the iCLA</a>

Please sign the iText Contributor License Agreement (iCLA) before sending pull requests. For any larger code
changes (more than 20 lines of significant code) to be accepted, the iCLA must be signed. It's a quick process, we promise!

We'll need you to [(digitally) sign and then email, fax or mail the form][cla].


## <a name="coc">Contributor Code of Conduct</a>
Please note that this project is released with a [Contributor Code of Conduct][coc]. By participating in this project you agree to abide by its terms.

We use the StackExchange network for free support and GitHub for code hosting. By using these services, you agree to abide by their terms:
* StackExchange: http://stackexchange.com/legal
* Github: https://help.github.com/articles/github-terms-of-service/


[cla]: http://itextpdf.com/policy
[coc]: https://github.com/itext/itextpdf/blob/master/CODE_OF_CONDUCT.md
[github]: https://github.com/itext/itextpdf
[itext-dev]: https://lists.sourceforge.net/lists/listinfo/itext-developers
[java-style-guide]: http://www.oracle.com/technetwork/java/codeconvtoc-136057.html
[javadocs]: http://itextpdf.com/api
[pull]: https://github.com/itext/itextpdf/pulls
[sscce]: http://sscce.org/
[stackoverflow]: http://stackoverflow.com/questions/tagged/itext
[good-questions]: http://stackoverflow.com/help/how-to-ask
[mcve]: http://stackoverflow.com/help/mcve
[support]: http://itextpdf.com/support
[unit-testing]: http://junit.org/
