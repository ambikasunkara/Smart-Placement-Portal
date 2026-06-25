import { useState } from 'react'
import { useParams, Link, Navigate } from 'react-router-dom'
import { getModuleById, learningModules } from '../data/learningModules'

export default function Course() {
  const { module } = useParams()
  const courseData = getModuleById(module)
  const [activeTopic, setActiveTopic] = useState(null)

  if (!courseData) {
    return <Navigate to="/" replace />
  }

  return (
    <div className="page">
      <div className="container">
        {/* Header */}
        <div className="course-header" style={{ background: `linear-gradient(135deg, ${courseData.color}22, transparent)` }}>
          <div className="course-icon-large" style={{ background: courseData.color + '22', color: courseData.color }}>
            {courseData.icon}
          </div>
          <div>
            <h1>{courseData.title}</h1>
            <p>{courseData.description}</p>
          </div>
        </div>

        {/* Topics */}
        {courseData.topics.map((topicGroup) => (
          <section key={topicGroup.category} className="course-section">
            <h2>{topicGroup.category}</h2>
            <div className="topic-grid">
              {topicGroup.items.map((item) => (
                <div key={item.name} className="topic-card">
                  <div className="topic-card-header">
                    <h4>{item.name}</h4>
                    <span className={`level-tag level-${item.level.toLowerCase()}`}>{item.level}</span>
                  </div>
                  <p>{item.desc}</p>
                  <button className="btn btn-outline btn-sm" onClick={() => setActiveTopic(item)}>
                    Start Topic
                  </button>
                </div>
              ))}
            </div>
          </section>
        ))}

        {/* Other Modules */}
        <section className="course-section">
          <h2>Explore Other Modules</h2>
          <div className="card-grid">
            {learningModules.filter((m) => m.id !== module).map((mod) => (
              <Link to={`/course/${mod.id}`} key={mod.id} className="module-card" style={{ borderTopColor: mod.color }}>
                <div className="module-icon" style={{ background: mod.color + '22', color: mod.color }}>
                  {mod.icon}
                </div>
                <h3>{mod.title}</h3>
                <p>{mod.description}</p>
                <span className="module-link" style={{ color: mod.color }}>Explore →</span>
              </Link>
            ))}
          </div>
        </section>
      </div>
      {activeTopic && (
        <div style={{
          position: 'fixed', top: 0, left: 0, width: '100%', height: '100%',
          background: 'rgba(0,0,0,0.5)', display: 'flex',
          alignItems: 'center', justifyContent: 'center', zIndex: 1000
        }}>
          <div style={{
            background: '#fff', borderRadius: '12px',
            padding: '32px', maxWidth: '480px', width: '90%'
          }}>
            <h2>{activeTopic.name}</h2>
            <span className={`level-tag level-${activeTopic.level.toLowerCase()}`}>
              {activeTopic.level}
            </span>
            <p style={{ marginTop: '16px', lineHeight: '1.6' }}>{activeTopic.desc}</p>
            <p style={{ marginTop: '12px', color: '#666' }}>
              Full study material and practice questions for this topic are coming soon!
            </p>
            <button
              className="btn btn-primary"
              style={{ marginTop: '20px' }}
              onClick={() => setActiveTopic(null)}
            >
              Close
            </button>
          </div>
        </div>
      )}
    </div>
  )
}
