const BASE_URL = 'http://localhost:8080/api'

function getToken() {
  return localStorage.getItem('token')
}

function authHeaders() {
  return {
    'Content-Type': 'application/json',
    Authorization: `Bearer ${getToken()}`,
  }
}

async function handleResponse(res) {
  const data = await res.json()
  if (!res.ok) {
    throw new Error(data.error || 'Something went wrong')
  }
  return data
}

export async function signup(name, email, password) {
  const res = await fetch(`${BASE_URL}/auth/signup`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, email, password }),
  })
  return handleResponse(res)
}

export async function login(email, password) {
  const res = await fetch(`${BASE_URL}/auth/login`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ email, password }),
  })
  return handleResponse(res)
}

export async function getDashboard() {
  const res = await fetch(`${BASE_URL}/dashboard`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getMockTests() {
  const res = await fetch(`${BASE_URL}/mock-tests`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getDailyPractice() {
  const res = await fetch(`${BASE_URL}/mock-tests/daily-practice`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getForumThreads() {
  const res = await fetch(`${BASE_URL}/community/threads`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function createForumThread(title, tag) {
  const user = localStorage.getItem('userName') || 'Anonymous'
  const res = await fetch(`${BASE_URL}/community/threads`, {
    method: 'POST',
    headers: authHeaders(),
    body: JSON.stringify({ title, tag, author: user }),
  })
  return handleResponse(res)
}

export async function getMentors() {
  const res = await fetch(`${BASE_URL}/community/mentors`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getStudyGroups() {
  const res = await fetch(`${BASE_URL}/community/study-groups`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getPeerInterviewSlots() {
  const res = await fetch(`${BASE_URL}/community/peer-interviews`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getLeaderboard() {
  const res = await fetch(`${BASE_URL}/leaderboard`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getHrQuestions() {
  const res = await fetch(`${BASE_URL}/interview/hr-questions`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}

export async function getHiringRounds() {
  const res = await fetch(`${BASE_URL}/interview/hiring-rounds`, {
    headers: authHeaders(),
  })
  return handleResponse(res)
}
