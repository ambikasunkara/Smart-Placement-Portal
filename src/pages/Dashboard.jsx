import { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { getDashboard, getLeaderboard } from '../api'
import { careerRoadmaps, predictedQuestions, studyTimetableTemplate } from '../data/appData'
import { learningModules } from '../data/learningModules'

export default function Dashboard() {
  const [userData, setUserData] = useState(null)
  const [leaderboard, setLeaderboard] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    async function loadData() {
      try {
        const [dash, lb] = await Promise.all([getDashboard(), getLeaderboard()])
        setUserData(dash)
        setLeaderboard(lb)
      } catch (err) {
        console.error('Failed to load dashboard', err)
      } finally {
        setLoading(false)
      }
    }
    loadData()
  }, [])

  if (loading) {
    return <div className="page"><div className="container"><p>Loading dashboard...</p></div></div>
  }

  if (!userData) {
    return <div className="page"><div className="container"><p>Failed to load dashboard data.</p></div></div>
  }

  return (
    <div className="page">
      <div className="container">
        <div className="dashboard-header">
          <div>
            <h1>Welcome back, {userData.name.split(' ')[0]} 👋</h1>
            <p>Here's your placement preparation overview.</p>
          </div>
          <div className="streak-badge">
            🔥 {userData.dailyStreak}-Day Streak
          </div>
        </div>

        <div className="stats-grid">
          <StatCard label="XP Points" value={userData.xp} icon="⚡" color="#6366f1" />
          <StatCard label="Level" value={userData.level} icon="🎮" color="#22c55e" />
          <StatCard label="Placement Readiness" value={`${userData.placementReadiness}%`} icon="🎯" color="#f59e0b" />
          <StatCard label="College" value={userData.college || 'Not set'} icon="🏫" color="#ec4899" />
        </div>

        <div className="dashboard-grid">
          <div className="dashboard-card">
            <h3>Skill Progress</h3>
            {userData.skillProgress.map((skill) => (
              <div key={skill.skill} className="progress-row">
                <div className="progress-label">
                  <span>{skill.skill}</span>
                  <span>{skill.progress}%</span>
                </div>
                <div className="progress-bar">
                  <div className="progress-fill" style={{ width: `${skill.progress}%` }}></div>
                </div>
              </div>
            ))}
          </div>

          <div className="dashboard-card readiness-card">
            <h3>Placement Readiness Score</h3>
            <div className="readiness-circle">
              <span>{userData.placementReadiness}</span>
              <small>/ 100</small>
            </div>
            <p>You're doing great! Focus on Coding & DSA and AI/Emerging Tech to boost your score further.</p>
          </div>

          <div className="dashboard-card">
            <h3>Daily Challenges</h3>
            <ul className="challenge-list">
              {userData.dailyChallenges.map((c) => (
                <li key={c.id} className={c.completed ? 'completed' : ''}>
                  <span className="challenge-check">{c.completed ? '✅' : '⬜'}</span>
                  <span className="challenge-title">{c.title}</span>
                  <span className="challenge-reward">{c.reward}</span>
                </li>
              ))}
            </ul>
          </div>

          <div className="dashboard-card">
            <h3>Your Badges</h3>
            <div className="badges-grid">
              {userData.badges.map((b) => (
                <div key={b.id} className={`badge-item ${b.earned ? 'earned' : 'locked'}`} title={b.description}>
                  <span className="badge-icon">{b.icon}</span>
                  <span className="badge-name">{b.name}</span>
                </div>
              ))}
            </div>
          </div>

          <div className="dashboard-card">
            <h3>Leaderboard</h3>
            <table className="leaderboard-table">
              <thead>
                <tr><th>Rank</th><th>Name</th><th>College</th><th>XP</th></tr>
              </thead>
              <tbody>
                {leaderboard.map((u) => (
                  <tr key={u.rank}>
                    <td>#{u.rank}</td>
                    <td>{u.name}</td>
                    <td>{u.college}</td>
                    <td>{u.xp.toLocaleString()}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>

          <div className="dashboard-card">
            <h3>Continue Learning</h3>
            <div className="quick-links">
              {learningModules.map((mod) => (
                <Link to={`/course/${mod.id}`} key={mod.id} className="quick-link" style={{ borderLeftColor: mod.color }}>
                  <span>{mod.icon}</span> {mod.title}
                </Link>
              ))}
            </div>
          </div>
        </div>

        <h2 className="section-title-spaced">AI-Powered Career Tools</h2>
        <div className="dashboard-grid">
          <div className="dashboard-card">
            <h3>🗺️ AI Career Roadmap Generator</h3>
            {careerRoadmaps.map((r) => (
              <div key={r.company} className="roadmap-block">
                <h4>{r.company} — {r.role}</h4>
                <ol>{r.steps.map((step, i) => <li key={i}>{step}</li>)}</ol>
              </div>
            ))}
          </div>

          <div className="dashboard-card">
            <h3>🗓️ Auto Study Timetable</h3>
            <div className="timetable">
              {studyTimetableTemplate.map((d) => (
                <div key={d.day} className="timetable-row">
                  <strong>{d.day}</strong>
                  <ul>{d.slots.map((s, i) => <li key={i}>{s}</li>)}</ul>
                </div>
              ))}
            </div>
          </div>

          <div className="dashboard-card">
            <h3>🔮 Interview Question Predictor</h3>
            <table className="leaderboard-table">
              <thead>
                <tr><th>Company</th><th>Predicted Question</th><th>Frequency</th></tr>
              </thead>
              <tbody>
                {predictedQuestions.map((q, i) => (
                  <tr key={i}>
                    <td>{q.company}</td>
                    <td>{q.question}</td>
                    <td><span className={`tag tag-${q.frequency.toLowerCase()}`}>{q.frequency}</span></td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  )
}

function StatCard({ label, value, icon, color }) {
  return (
    <div className="stat-card">
      <div className="stat-icon" style={{ background: color + '22', color }}>{icon}</div>
      <div>
        <div className="stat-value">{value}</div>
        <div className="stat-label-small">{label}</div>
      </div>
    </div>
  )
}
