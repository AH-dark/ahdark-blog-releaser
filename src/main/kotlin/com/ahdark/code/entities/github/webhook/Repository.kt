package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class Repository(
    val id: Long,

    @SerialName("node_id")
    val nodeID: String,

    val name: String,

    @SerialName("full_name")
    val fullName: String,

    val private: Boolean,
    val owner: Sender,

    @SerialName("html_url")
    val htmlURL: String,

    val description: String,
    val fork: Boolean,
    val url: String,

    @SerialName("forks_url")
    val forksURL: String,

    @SerialName("keys_url")
    val keysURL: String,

    @SerialName("collaborators_url")
    val collaboratorsURL: String,

    @SerialName("teams_url")
    val teamsURL: String,

    @SerialName("hooks_url")
    val hooksURL: String,

    @SerialName("issue_events_url")
    val issueEventsURL: String,

    @SerialName("events_url")
    val eventsURL: String,

    @SerialName("assignees_url")
    val assigneesURL: String,

    @SerialName("branches_url")
    val branchesURL: String,

    @SerialName("tags_url")
    val tagsURL: String,

    @SerialName("blobs_url")
    val blobsURL: String,

    @SerialName("git_tags_url")
    val gitTagsURL: String,

    @SerialName("git_refs_url")
    val gitRefsURL: String,

    @SerialName("trees_url")
    val treesURL: String,

    @SerialName("statuses_url")
    val statusesURL: String,

    @SerialName("languages_url")
    val languagesURL: String,

    @SerialName("stargazers_url")
    val stargazersURL: String,

    @SerialName("contributors_url")
    val contributorsURL: String,

    @SerialName("subscribers_url")
    val subscribersURL: String,

    @SerialName("subscription_url")
    val subscriptionURL: String,

    @SerialName("commits_url")
    val commitsURL: String,

    @SerialName("git_commits_url")
    val gitCommitsURL: String,

    @SerialName("comments_url")
    val commentsURL: String,

    @SerialName("issue_comment_url")
    val issueCommentURL: String,

    @SerialName("contents_url")
    val contentsURL: String,

    @SerialName("compare_url")
    val compareURL: String,

    @SerialName("merges_url")
    val mergesURL: String,

    @SerialName("archive_url")
    val archiveURL: String,

    @SerialName("downloads_url")
    val downloadsURL: String,

    @SerialName("issues_url")
    val issuesURL: String,

    @SerialName("pulls_url")
    val pullsURL: String,

    @SerialName("milestones_url")
    val milestonesURL: String,

    @SerialName("notifications_url")
    val notificationsURL: String,

    @SerialName("labels_url")
    val labelsURL: String,

    @SerialName("releases_url")
    val releasesURL: String,

    @SerialName("deployments_url")
    val deploymentsURL: String,

    @SerialName("created_at")
    val createdAt: Long,

    @SerialName("updated_at")
    val updatedAt: String,

    @SerialName("pushed_at")
    val pushedAt: Long,

    @SerialName("git_url")
    val gitURL: String,

    @SerialName("ssh_url")
    val sshURL: String,

    @SerialName("clone_url")
    val cloneURL: String,

    @SerialName("svn_url")
    val svnURL: String,

    val homepage: String,
    val size: Long,

    @SerialName("stargazers_count")
    val stargazersCount: Long,

    @SerialName("watchers_count")
    val watchersCount: Long,

    val language: String,

    @SerialName("has_issues")
    val hasIssues: Boolean,

    @SerialName("has_projects")
    val hasProjects: Boolean,

    @SerialName("has_downloads")
    val hasDownloads: Boolean,

    @SerialName("has_wiki")
    val hasWiki: Boolean,

    @SerialName("has_pages")
    val hasPages: Boolean,

    @SerialName("has_discussions")
    val hasDiscussions: Boolean,

    @SerialName("forks_count")
    val forksCount: Long,

    @SerialName("mirror_url")
    val mirrorURL: String? = null,

    val archived: Boolean,
    val disabled: Boolean,

    @SerialName("open_issues_count")
    val openIssuesCount: Long,

    val license: License? = null,

    @SerialName("allow_forking")
    val allowForking: Boolean,

    @SerialName("is_template")
    val isTemplate: Boolean,

    @SerialName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean,

    val topics: List<String>,
    val visibility: String,
    val forks: Long,

    @SerialName("open_issues")
    val openIssues: Long,

    val watchers: Long,

    @SerialName("default_branch")
    val defaultBranch: String,

    val stargazers: Long,

    @SerialName("master_branch")
    val masterBranch: String,

    val organization: String? = null,

    @SerialName("custom_properties")
    val customProperties: JsonElement? = null
)
