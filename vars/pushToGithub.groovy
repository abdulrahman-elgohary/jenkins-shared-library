def call(Map envVars) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git remote set-url origin ${envVars.gitRepo}

    # Stash changes before pulling the latest code
    git stash push --include-untracked -m "Jenkins auto-stash"

    # Ensure we're on the latest branch
    git checkout ${envVars.branch}
    git pull --rebase origin ${envVars.branch}

    # Apply stashed changes if any
    git stash apply || echo "No stash to apply"
    git stash drop || echo "No stash to drop"

    # Commit and push
    git add .
    git commit -m "Automated commit by Jenkins" || echo "No changes to commit"
    git push origin ${envVars.branch}
    """
}
