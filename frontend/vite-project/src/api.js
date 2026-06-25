const BASE_URL = 'http://localhost:8081/api'

function getUserId() {
  return localStorage.getItem('userId')
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
  const userId = getUserId()
  const res = await fetch(`${BASE_URL}/dashboard/${userId}`)
  return handleResponse(res)
}

export async function getMockTests() {
  const res = await fetch(`${BASE_URL}/mock-tests`)
  return handleResponse(res)
}

export async function getDailyPractice() {
  const res = await fetch(`${BASE_URL}/mock-tests/daily-practice`)
  return handleResponse(res)
}

export async function getForumThreads() {
  const res = await fetch(`${BASE_URL}/community/threads`)
  return handleResponse(res)
}

export async function createForumThread(title, tag) {
  const author = localStorage.getItem('userName') || 'Anonymous'
  const res = await fetch(`${BASE_URL}/community/threads`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ title, tag, author }),
  })
  return handleResponse(res)
}

export async function getMentors() {
  const res = await fetch(`${BASE_URL}/community/mentors`)
  return handleResponse(res)
}

export async function getStudyGroups() {
  const res = await fetch(`${BASE_URL}/community/study-groups`)
  return handleResponse(res)
}

export async function getPeerInterviewSlots() {
  const res = await fetch(`${BASE_URL}/community/peer-interviews`)
  return handleResponse(res)
}

export async function getHrQuestions() {
  const res = await fetch(`${BASE_URL}/interview/hr-questions`)
  return handleResponse(res)
}

export async function getHiringRounds() {
  const res = await fetch(`${BASE_URL}/interview/hiring-rounds`)
  return handleResponse(res)
}
