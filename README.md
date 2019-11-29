# SQTA Project 1

Champlain SQTA 420-521-LA Project 1 repo

## Structure

- Only make changes i.e. pull requests to your teams folder, if you see someone making a pr on another teams folder do not accept it
- Please following standard naming convention as stated in the 'story workflow' section and also don't forget to label your pull requests

### Project Structure

- There are 4 teams (A, B, C, D)
- Each team has their respective root project folder

### Branch Naming

- Branches can really be called whatever but it will help to name them smth you can easily remember, I like to break it down into 4 'folders'
    - feat/
    - bug/
    - gen/
    - conf/
- For this project you will only need to use `feat/` and `bug/` or whatever naming convention you like this is just a recommendation if you are lost
- After the slash add the JIRA id so smth like SQTA-4, the full branch name would look like this `feat/SQTA-4` and would be created and navigated to by

```
git checkout -b feat/SQTA-4
```

### Pull Requests (PR) Naming

- To make it so we can easily search and find pull requests it is nice to follow a standard such as

```
[JIRA-TICKET-ID] [TEAM A] Short description
```

- In that example You would replace JIRA-TICKET-ID with the id and team A with whatever team you are on, keep the square brackets

### Pull Request Commit Naming

- Pretty much the exact same as Pull Request naming except at the end there will be an auto generated number in parens, please don't delete it and just add your stuff before it i.e.

```
[JIRA-TICKET-ID] [TEAM A] Short description (#420)
```

## Setup

- First create an account on GitHub
- Download git https://git-scm.com/downloads
- Go to the official/ main repo https://github.com/cgerard321/sqta-project-1
- At the top right of the page click 'fork'
- Navigate to your forks page, click the green button 'clone or download', and copy the url given
- On your file explorer naviagte to where you want the project, right click and select 'git bash here'
- In the terminal window type 'git clone' and then paste the copied url, it will look like this (Do not ctrl + v to paste in the git bash terminal, it does not use standard windows encoding and will add extra invisible chars to the command causing it to error out):

```
git clone https://github.com/YOUR-USER-NAME/sqta-project-1
```

- We now have your fork of the 'official' repo locally
- From now on the 'official' or main repo can also be reffered to as the 'upstream' and your fork of the 'upstream' can be called the origin as per standard naming conventions
- Next we will set up a remote to the upstream which will allow us to 'talk' to it

```
git remote add upstream https://github.com/cgerard321/sqta-project-1.git
```

- If we type `git remote -v` we should see 4 different connections, push and fetch for our upstream and for our origin
- When you make any git command it will add `origin` implicitly so it means you are doing that command on your fork of the upstream repo
- Think of your fork as an instance of the `upstream` repo if you enjoy programming metaphors
- You have now setup your basic fork, move on to the 'story workflow section'

## Story Workflow

- So you setup your fork of the repo and started your first story now what
- We will first navigate to our project in the file explorer, right click and select 'git bash here'
- In the current command line you should see in parens the branch you are currently on, we want to start this 'new story process' from our origins master branch
- If it says master, great skip this next line if not then don't skip it

```
git checkout master
```

- This will simply transfer us to our origins master
- Next we will want to update our local project with any code our fellow devs have pushed while we were gone, to do this we must first 'download' the code

```
git fetch upstream master
```

- We are telling git to take the latest stuff from the master branch on our upstream remote
- Then we want to actually start our story fresh with that code, so we will reset our local env with that new fetched code, don't ask why this uses a forward slash and the other command uses a space, no one knows

```
git reset --hard upstream/master
```

- It is also important to note this will reset any uncommited changes you've made, so keep that in mind if you are following along and not starting a story from scratch you might want to rebase instead, more info on rebasing can be found in the 'useful git commands' section

- Now we will want to make a new branch to start work on our feature or bug fix, simply type

```
git checkout -b YOUR-BRANCH-NAME
```

- This command is broken down into 2 parts, `checkout` will move you to a given branch the `-b` modifier will create the branch
- You have now created your new branch and are on it, check the 'structure' section for what you should write in place of YOUR-BRANCH-NAME
- Now its time to unfortunately actually write some code, so go fix the bug or make the test and then come back
- So now you have hopefully something done or atleast the start to it and want to commit it
- First we have to stage all edits, additions, and removals

```
git add .
```

- We can also stage specific files with a relative path

```
git add /path/to/file
```

- Next we will commit the code

```
git commit -m "A short description of what work was done in the commit"
```

- After that you might repeat the `git add .` and `git commit` a couple times before your master piece is done

- When you are ready to show it to everyone else or if you want to be able to access it on another computer we have to push it with this command, it might ask you for login creds

```
git push
```

- Again this is the same this as saying `git push origin master` the `origin` and `master` are implicity typed

- Imagine at this point everything in the story is done and you are ready to get it code reviewed by the other devs, we need to make a pull request to do that
- Go to your origins github page or the upstreams and make a new pull request, at the top verify that the branch and HEAD are all coming from and going to the correct place
- Add a title documented in the 'structure' section and make sure to add the label on the side bar indicating which team you are on
- In order to merge this pr we need two other people to review and approve it, you can get other peoples attention by 'requesting a review' on the side bar
- Start by asking people on your team to do the review but don't hesitate to ask someone from a different team
- Once you've pleased everyone, your code is in prime condition, and you have no merge conflicts you can finally hit the 'squash and merge' button and set another title in which the naming conventions are documented in the 'Pull Request Commit Naming' section of 'Structure'
- Your pr is now merged on the upstream master and everyone can fetch and rebase to see the work you've done
- Congrats just repeat this process until the semester is over

## Merge conflicts / Updating your branch

### The commands are pretty much the same if you are updating a branch or if you are trying to fix a merge conflict, except if you are updating you will skip the `git add .` and the `git rebase --continue` because you don't have anything to fix, you will still have to `git push -f`

Oh no, you have a merge conflict, this happens when you and another dev are working on the same file and edit the same line or git can't automatically figure out how to add your code and the upstream master code together

Once you see this error on your pull request or if you happen to run into it outside of a pr just follow these easy steps

- First download the upstream master data

```
git fetch upstream master
```

- Next we will use the rebase command

```
git rebase upstream/master
```

- Git will now replay the commits of your branch on top of the upstream master, if you have a merge conflict the prompt will pause and tell you which files were effected. From there just navigate to your file and update the code accordingly

- Once you have fixed all the merge conflicts go back to your terminal and type

```
git add .
```

- Then

```
git rebase --continue
```

- This command is telling git ok I've fixed this conflict now move on to the next commit

- If you have more conflicts just repeat the last couple of steps, until the rebase is complete

- Generally you can tell the rebase is complete when you look at the branch name in your terminal and it is the correct branch name i.e. without any extra text or random symbols

- After that the rebase has made a new local commit with all your changes, only one step left which is to force push

```
git push -f
```

- This is just short hand for `git push --force`

- If you don't force push you'll get a bunch of red and yellow text, which looks like you messed up but it's fine. It didn't actually do anything just redo the command but with the `-f`

- Should be all done if you go back to your pull request the branch should be able to automatically merge

## Useful Git Commands

This command lets you see any edited, added, or removed files:

```
git status
```

This will show you the difference in what the last commit and your local repo is, press q when you want to leave:

```
git diff HEAD .
```

This will list all your remotes:

```
git remote -v
```

This will list all your branches and there will be a star next to the branch you are currently on:

```
git branch
```

Reset your current branch to the upstream master:

```
git fetch upstream master
git reset --hard upstream/master
```

If you want to rebase the upstream master on top of your working branch:

```
git fetch upstream master
git rebase upstream/master
```

Switch to a branch:

```
git checkout BRANCH-NAME
```

Creating and switching to a branch:

```
git checkout -b BRANCH-NAME
```

Add all files ot be staged:

```
git add .
```

Remove all files from staging area:

```
git reset HEAD .
```

Commit all staged files:

```
git commit -m "My message"
```

Push code to remote repo:

```
git push
```

Push code to remote repo after rebase, use this one carefully:

```
git push --force
```

Select a specific commit and replay in onto a branch, don't include angled brackets:

```
git cherry-pick <commitId>
```

To save the stuff you have been working on if you need to quickly change branches but don't want to commit or want to transfer work from one branch to another, the basic is with git stash and there are a variety of variation you can look up but for general uses, this first command will store the data:

```
git stash
```

The next command will re-apply the data:

```
git stash pop
```
